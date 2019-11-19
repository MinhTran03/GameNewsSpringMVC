package com.springmvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.models.Role;
import com.springmvc.models.UserInfo;
import com.springmvc.models.UserLogin;
import com.springmvc.services.UserService;
import com.springmvc.validator.LoginValidator;

@Controller
@RequestMapping("/login")
@SessionAttributes("current_user")
public class LoginController {
	
	@Autowired
	LoginValidator userValidator;

	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession httpSession;
	
	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		UserInfo user = (UserInfo)httpSession.getAttribute("current_user");
		
		if(user != null) {
			return "redirect:/";
		}
		
		model.addAttribute("userLogin", new UserLogin());
		
		return "login/login-page";
	}
	
	@RequestMapping(name = "/", method = RequestMethod.POST)
	public String check(ModelMap model, @ModelAttribute("userLogin") UserLogin user, BindingResult bind) {
		
		userValidator.validate(user, bind);
		if (bind.hasErrors()) {
			return "login/login-page";
		}
		
		// Kiểm tra thông tin user
		List<Role> listRole = userService.checkLogin(user.getEmail(), user.getPassword());
		
		if(listRole == null) {
			// login fail
			model.addAttribute("message", "Login fail");
			return "login/login-page";
		}else {
			UserInfo userLogin = userService.getById(userService.getIdByEmail(user.getEmail()));
			model.addAttribute("current_user", userLogin);
			
			listRole.forEach(item -> {
				System.out.println(item.getRoleName());
			});
		}
		
		String url = "";
		String temp = (String)httpSession.getAttribute("save_url");
		if(temp != null)
			url = (temp).replaceAll("/GameNews/", "");
		System.out.println(url);
		
		return "redirect:/" + url;
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
}
