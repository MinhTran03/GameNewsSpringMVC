package com.springmvc.controllers;

import static com.springmvc.util.CurrentLogin.fullName;
import static com.springmvc.util.CurrentLogin.id;
import static com.springmvc.util.CurrentLogin.imagePath;
import static com.springmvc.util.CurrentLogin.loggingIn;
import static com.springmvc.util.CurrentLogin.roles;
import static com.springmvc.util.CurrentLogin.userName;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.models.Role;
import com.springmvc.models.UserInfo;
import com.springmvc.models.UserLogin;
import com.springmvc.services.UserService;
import com.springmvc.util.CurrentLogin;
import com.springmvc.validator.LoginValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginValidator userValidator;

	@Autowired
	UserService userService;
	
	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		if(CurrentLogin.loggingIn == true) {
			return "redirect:" + CurrentLogin.redirectStr;
		}
		
		model.addAttribute("userLogin", new UserLogin());
		
		System.out.println("======================================new user");
		return "login/login-page";
	}
	
	@RequestMapping(name = "/", method = RequestMethod.POST)
	public String check(ModelMap model, @ModelAttribute("userLogin") UserLogin user, BindingResult bind) {
		System.out.println("====================");
		userValidator.validate(user, bind);
		if (bind.hasErrors()) {
			System.out.println("===error");
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
			loggingIn = true;
			userName = user.getEmail();
			roles = listRole;
			id = userService.getIdByEmail(userName);
			fullName = userService.getFullName(id);
			System.out.println(fullName);
			fullName = fullName.replaceFirst("null ", "");
			imagePath = userLogin.getImage();
			System.out.println("==================================" + imagePath);
			
			listRole.forEach(item -> {
				System.out.println(item.getRoleId());
				System.out.println(item.getRoleName());
			});
		}
		if(CurrentLogin.redirectStr.startsWith("/GameNews")) {
			CurrentLogin.redirectStr = CurrentLogin.redirectStr.substring(9, CurrentLogin.redirectStr.length());
		}
		
		System.out.println(CurrentLogin.redirectStr);
		return "redirect:" + CurrentLogin.redirectStr;//"redirect:/" + CurrentLogin.redirectStr;
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
}
