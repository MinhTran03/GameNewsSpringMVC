package com.springmvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {

		httpSession.setAttribute("current_user", null);
		
		return "redirect:/";
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
}
