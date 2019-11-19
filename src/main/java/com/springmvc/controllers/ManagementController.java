package com.springmvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.models.Post;
import com.springmvc.models.Topic;
import com.springmvc.services.PostService;
import com.springmvc.services.TopicService;
import com.springmvc.services.UserService;

@Controller
@RequestMapping("/management")
public class ManagementController {

	public final int MAX_USER_PER_PAGE = 5;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	TopicService topicService;
	
	@RequestMapping("/user-list")
	public String userList(ModelMap model, @RequestParam(defaultValue = "1") int page) {
		
		int calPage = page - 1;
		int totalUser = userService.countUserOfRole("AUTHOR");
		int pageCount = (totalUser - 0) / MAX_USER_PER_PAGE - ((totalUser % MAX_USER_PER_PAGE) == 0 ? 1 : 0);
		
		model.addAttribute("listUser", userService.getInRange(calPage * 5, page * 5, "AUTHOR"));
		model.addAttribute("totalUser", totalUser);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currentPage", page);
		
		return "management/user-list";
	}

	@RequestMapping(value = "/dashboard")
	public String dashb(ModelMap model, @RequestParam(defaultValue = "1") int page) {
		
		// lấy bài đăng status = false
//		List<Post> list = postService.getAllNotConfirm();
//		
//		List<String> topicName = new ArrayList<String>();
//		List<String> authorName = new ArrayList<String>();
//		List<Integer> authorId = new ArrayList<Integer>();
//		for(Post item : list) {
//			topicName.add(topicService.getById(item.getTopicId()).getName());
//			authorName.add(userService.getById(item.getUserId()).getFullName());
//			authorId.add(item.getUserId());
//		}
//		model.addAttribute("listTopicName", topicName);
//		model.addAttribute("listAuthorName", authorName);
//		model.addAttribute("listAuthorId", authorId);
//		
//		model.addAttribute("listPost", list);
		
		return "management/dashboard";
	}
	
	@RequestMapping(value = "/duyet-bai")
	public String baiDangChoDuyet(ModelMap model, @RequestParam(defaultValue = "1") int page) {
		
		// lấy bài đăng status = false
		List<Post> list = postService.getAllNotConfirm();
		
		List<String> topicName = new ArrayList<String>();
		List<String> authorName = new ArrayList<String>();
		List<Integer> authorId = new ArrayList<Integer>();
		for(Post item : list) {
			topicName.add(topicService.getById(item.getTopicId()).getName());
			authorName.add(userService.getById(item.getUserId()).getFullName());
			authorId.add(item.getUserId());
		}
		model.addAttribute("listTopicName", topicName);
		model.addAttribute("listAuthorName", authorName);
		model.addAttribute("listAuthorId", authorId);
		
		model.addAttribute("listPost", list);
		
		return "management/duyetbai";
	}
	
	@RequestMapping(value="demo/{postId}")
	public String demo(ModelMap model, @PathVariable int postId) {
		
		Post post = postService.getById(postId);
		
		model.addAttribute("post", post);
		model.addAttribute("content", post.getContent());
		model.addAttribute("listTag", post.getListTag());
		Topic topic = topicService.getById(post.getTopicId());
		model.addAttribute("topic", topic.getName());
		model.addAttribute("authorName", userService.getFullName(post.getUserId()));
		
		return "author/post-demo";
	}
	
	@RequestMapping(value="/acceptPost")
	@ResponseBody
	public String acceptPost(@RequestParam int postId, @RequestParam int authorId) {
		
		boolean result = postService.acceptPost(postId, authorId);
		
		return result ? "true" : "false";
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
}