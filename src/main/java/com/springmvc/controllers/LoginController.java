package com.springmvc.controllers;

import static com.springmvc.util.CurrentLogin.id;
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
import com.springmvc.services.UserService;
import com.springmvc.util.CurrentLogin;
import com.springmvc.validator.UserValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserValidator userValidator;

	@Autowired
	UserService userService;
	
	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		model.addAttribute("userLogin", new UserInfo());
		
		System.out.println("======================================new user");
		return "login/login-page";
	}
	
	@RequestMapping(name = "/", method = RequestMethod.POST)
	public String check(ModelMap model, @ModelAttribute("userLogin") UserInfo userLogin, BindingResult bind) {
		System.out.println("====================");
		userValidator.validate(userLogin, bind);
		if (bind.hasErrors()) {
			System.out.println("===error");
			return "login/login-page";
		}
		
		// Kiểm tra thông tin user
		List<Role> listRole = userService.checkLogin(userLogin.getEmail(), userLogin.getPassword());
		
		if(listRole == null) {
			// login fail
			model.addAttribute("message", "Login fail");
			return "login/login-page";
		}else {
			loggingIn = true;
			userName = userLogin.getEmail();
			roles = listRole;
			id = userService.getIdByEmail(userName);
			System.out.println(id);
			
			listRole.forEach(item -> {
				System.out.println(item.getRoleId());
				System.out.println(item.getRoleName());
			});
		}
		CurrentLogin.redirectStr = CurrentLogin.redirectStr.substring(9, CurrentLogin.redirectStr.length());
		System.out.println(CurrentLogin.redirectStr);
		return String.format("redirect:%s", CurrentLogin.redirectStr);//"redirect:/" + CurrentLogin.redirectStr;
	}
	
}
