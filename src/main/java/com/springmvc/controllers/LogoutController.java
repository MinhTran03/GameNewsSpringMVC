package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.util.CurrentLogin;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String logout() {
		CurrentLogin.loggingIn = false;
		return "redirect:" + CurrentLogin.redirectStr;
	}
	
}
