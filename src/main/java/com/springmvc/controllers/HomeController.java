package com.springmvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.models.Post;
import com.springmvc.models.Topic;
import com.springmvc.models.UserInfo;
import com.springmvc.services.PostService;
import com.springmvc.services.TopicService;
import com.springmvc.services.UserService;
import com.springmvc.util.CurrentLogin;


@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@Autowired
	TopicService topicService;
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/edit-user")
	public String editUser(ModelMap model) {
		
		UserInfo user = userService.getById(CurrentLogin.id);
		model.addAttribute("newUser", user);
		model.addAttribute("edit", true);
		
		return "login/register-page";
	}
	
	@RequestMapping(value = "/")
	public String home(@RequestParam(name = "language", defaultValue = "en") String lang) {
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
	
	@RequestMapping("/not-have-permistion")
	public String fail() {
		return "cannotmodify";
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
	
}
