package com.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.models.UserInfo;
import com.springmvc.services.UserService;
import com.springmvc.validator.UserValidator;

@Controller
public class RegisterController {
	
	@Autowired
	UserValidator userValidator;

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		
		model.addAttribute("newUser", new UserInfo());
		
		return "login/register-page";
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String signUp(ModelMap model, @ModelAttribute("newUser") UserInfo newUser, BindingResult bind) {
		
		userValidator.validate(newUser, bind);
		if(bind.hasErrors()) {
			return "login/register-page";
		}
		
		if(userService.isContainEmail(newUser.getEmail()) == false) {
			userService.save(newUser);
		}else {
			bind.rejectValue("email", "Email.Exist");
			return "login/register-page";
		}
		
		return "redirect:/game-home";
	}
}
