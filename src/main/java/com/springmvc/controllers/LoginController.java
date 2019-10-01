package com.springmvc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.springmvc.models.Role;
import com.springmvc.services.UserService;
import static com.springmvc.util.CurrentLogin.*;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String login() {
		return "login/login-page";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String check(ModelMap model,
						@RequestParam String username,
						@RequestParam String password) {
		
		// Kiểm tra thông tin user
		List<Role> listRole = userService.checkLogin(username, password);
		
		if(listRole == null) {
			// login fail
			model.addAttribute("message", "Login fail");
			return "login/login-page";
		}else {
			id = 1;
			userName = username;
			roles = listRole;
			
			listRole.forEach(item -> {
				System.out.println(item.getRoleId());
				System.out.println(item.getRoleName());
			});
		}
		
		return "redirect:/author/post";
	}
	
}
