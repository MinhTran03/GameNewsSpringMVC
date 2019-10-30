package com.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.services.UserService;

@Controller
@RequestMapping("/management")
public class ManagementController {

	public final int MAX_USER_PER_PAGE = 5;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/user-list")
	public String userList(ModelMap model, @RequestParam(defaultValue = "1") int page) {
		
		int calPage = page - 1;
		int totalUser = userService.countUserOfRole("AUTHOR");
		int pageCount = (totalUser - 0) / MAX_USER_PER_PAGE - ((totalUser % MAX_USER_PER_PAGE) == 0 ? 1 : 0);
		
		model.addAttribute("listUser", userService.getInRange(calPage * 5, page * 5, "AUTHOR"));
		model.addAttribute("totalUser", totalUser);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currentPage", page);
		
		return "management/list-user";
	}

	@RequestMapping("/dashboard")
	public String dashBoard(ModelMap model) {
		
		
		
		return "management/dashboard";
	}
}
