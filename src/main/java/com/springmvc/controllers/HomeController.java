package com.springmvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.models.Post;
import com.springmvc.models.Topic;
import com.springmvc.models.UserInfo;
import com.springmvc.services.PostService;
import com.springmvc.services.TopicService;
import com.springmvc.services.UserService;
import com.springmvc.util.PasswordGenerator;

@Controller
@SessionAttributes("temp_user")
public class HomeController {

	@Autowired
	UserService userService;
	
	@Autowired
	TopicService topicService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	JavaMailSender mailer;
	
	@Autowired
	HttpSession httpSession;
	
	@RequestMapping(value = "/edit-user")
	public String editUser(ModelMap model) {
		
		UserInfo currentUser = (UserInfo)httpSession.getAttribute("current_user");
		
		UserInfo user = userService.getById(currentUser.getUserId());
		model.addAttribute("newUser", user);
		model.addAttribute("edit", true);
		
		return "login/register-page";
	}
	
	@RequestMapping(value = "/")
	public String home(@RequestParam(name = "language", defaultValue = "en") String lang, ModelMap model) {
		
		return "redirect:topic/game-home";
	}
	
	@RequestMapping(value = "/home")
	public String search(@RequestParam String search, ModelMap model) {
		
		// Topic taskbar
		List<Topic> listTopic = topicService.getAll();
		model.addAttribute("listTopic", listTopic);

		List<Post> listPost = postService.search(search);
		// Page post
		List<String> authorName = new ArrayList<>();
		for(Post item : listPost) {
			authorName.add(userService.getById(item.getUserId()).getFullName());
		}
		model.addAttribute("listPost", listPost);
		model.addAttribute("authorName", authorName);

		model.addAttribute("searchBy", search);

		return "topic/search-post";
		
	}
	
	@RequestMapping(value="/forget-pass")
	public String forget() {
		
		return "login/input-email";
	}
	
	@RequestMapping(value="/forget-pass", method = RequestMethod.POST)
	public String forgetcommit(@RequestParam String email, ModelMap model) {
		
		int id = userService.getIdByEmail(email);
		if(id == -1) {
			model.addAttribute("errorCode", "Email chưa đăng ký, vui lòng kiểm tra lại");
			return "login/input-email";
		}
		
		// Tạo password ngẫu nhiên
		PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder().useDigits(true)
				.useLower(true).useUpper(true).build();
		String secrectCode = passwordGenerator.generate(12);
		
		// Gửi password tới email đăng ký
		sendMail(email, "Notification from Game News", "Your private code is " + secrectCode);
		
		UserInfo newUser = new UserInfo();
		newUser.setEmail(email);
		newUser.setPrivateCode(secrectCode);
		model.addAttribute("temp_user", newUser);
		
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
	
	@RequestMapping(value="/change-pass", method = RequestMethod.POST)
	public String changepass(ModelMap model, @RequestParam String privateCode) {
		
		UserInfo user = (UserInfo)httpSession.getAttribute("temp_user");
		
		if(user.getPrivateCode().contentEquals(privateCode)) {
			
			return "login/new-pwd";
		}
		
		model.addAttribute("errorCode", "Code không đúng");
		return "login/confirm-email";
	}
	
	@RequestMapping(value="/commit-pass", method = RequestMethod.POST)
	public String commitPass(ModelMap model, @RequestParam String pass, @RequestParam String confirmPass) {
		
		if(!pass.contentEquals(confirmPass)) {
			model.addAttribute("errorCode", "Không khớp");
			return "login/new-pwd";
		}
		
		UserInfo user = (UserInfo)httpSession.getAttribute("temp_user");
		user = userService.getById(userService.getIdByEmail(user.getEmail()));
		user.setPassword(pass);
		userService.save(user);
		model.addAttribute("changeSuccess", "CHange pass success");
		
		return "redirect:login";
	}
	
	@RequestMapping("/not-have-permistion")
	public String fail() {
		return "cannotmodify";
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
	
}
