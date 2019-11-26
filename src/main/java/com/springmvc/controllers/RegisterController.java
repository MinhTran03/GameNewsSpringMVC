package com.springmvc.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.models.UserInfo;
import com.springmvc.services.UserService;
import com.springmvc.util.PasswordGenerator;
import com.springmvc.validator.UserValidator;

@Controller
@RequestMapping("/sign-up")
@SessionAttributes("temp_user")
public class RegisterController {
	
	@Autowired
	UserValidator userValidator;

	@Autowired
	UserService userService;
	
	@Autowired
	JavaMailSender mailer;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String register(ModelMap model) {
		
		model.addAttribute("newUser", new UserInfo());
		model.addAttribute("edit", false);
		return "login/register-page";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String signUp(ModelMap model,
			@ModelAttribute("newUser") UserInfo newUser, BindingResult bind) {
		
		if(newUser.getUserId() == 0) {			
			userValidator.validate(newUser, bind);
			if(bind.hasErrors()) {
				return "login/register-page";
			}
			
			if(userService.isContainEmail(newUser.getEmail()) == false) {
				
				// Tạo code ngẫu nhiên
				PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder().useDigits(true)
						.useLower(true).useUpper(true).build();
				String secrectCode = passwordGenerator.generate(12);
	
				// Gửi code tới email đăng ký
				sendMail(newUser.getEmail(), "Notification from Game News", "Your private code is " + secrectCode);
				newUser.setPrivateCode(secrectCode);
				model.addAttribute("temp_user", newUser);
				model.addAttribute("regis", true);
				
				return "login/confirm-email";
			}else {
				bind.rejectValue("email", "Email.Exist");
				
				return "login/register-page";
			}
		}else {
			userValidator.validate(newUser, bind);
			if(bind.hasErrors()) {
				return "login/register-page";
			}
			userService.update(newUser);
			return "redirect:/topic/game-home";
		}
	}
	
	@RequestMapping(value = "/confirm-email", method = RequestMethod.POST)
	public String confirmEmail(HttpSession httpSession, ModelMap model, @RequestParam String privateCode) {
		
		UserInfo user = (UserInfo)httpSession.getAttribute("temp_user");
		
		if(user.getPrivateCode().contentEquals(privateCode)) {
			if(user.getPassword() == null) {
				
				user = userService.getById(userService.getIdByEmail(user.getEmail()));
				
				httpSession.setAttribute("current_user", user);
				model.addAttribute("newUser", user);
				model.addAttribute("edit", true);
				
				return "login/register-page";
			}else {
				userService.save(user);
				return "redirect:/topic/game-home";				
			}
		}
		model.addAttribute("errorCode", "Code not match");
		return "login/confirm-email";
	}
	
	public boolean sendMail(String to, String subject, String body) {
		try {
			// tạo mail
			MimeMessage mail = mailer.createMimeMessage();

			// sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			String from = "tranconminh503@gmail.com";
			helper.setFrom(from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);

			mailer.send(mail);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
}
