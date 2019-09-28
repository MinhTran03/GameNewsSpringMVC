package com.springmvc.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springmvc.models.*;
import com.springmvc.services.*;

@Controller
public class TopicController {

	public final int MAX_POST_PER_PAGE = 10;
	
	@Autowired
	@Qualifier("topicServiceImpl")
	ServiceBase<Topic> topicServiceBase;

	@Autowired
	@Qualifier("postServiceImpl")
	ServiceBase<Post> postServiceBase;

	@Autowired
	@Qualifier("authorServiceImpl")
	ServiceBase<Author> authorServiceBase;

	@Autowired
	PostService postService;

	@Autowired
	AuthorService authorService;

//	@ModelAttribute(name = "listTopic")
//	public List<Topic> getListTopic() {
//		List<Topic> listTopic = topicServiceBase.getAll();
//
//		return listTopic;
//	}
//
//	// get top 3 newest post
//	@ModelAttribute(name = "topPost")
//	public List<Post> getTopPost(ModelMap model) {
//
//		List<Post> topNPost = postService.getTopNewest(3, 1);
//
//		List<String> topAuthorName = new ArrayList<>();
//		for (int i = 0; i < topNPost.size(); i++) {
//			topAuthorName.add(authorService.getFullName(topNPost.get(i).getAuthorId()));
//		}
//		model.addAttribute("topAuthorName", topAuthorName);
//
//		return topNPost;
//	}

	@RequestMapping(value = "/{topicName:[a-zA-Z0-9-]+}", method = RequestMethod.GET)
	public String home(ModelMap model, @PathVariable("topicName") String topicName) {

		// Topic taskbar
		List<Topic> listTopic = topicServiceBase.getAll();
		model.addAttribute("listTopic", listTopic);

		// Map topicName to topicId
		int topicId = -1;
		topicName = topicName.replace('-', ' ').toUpperCase();
		for (Topic topic : listTopic) {
			if (topic.getName().equals(topicName)) {
				topicId = topic.getTopicId();
				break;
			}
		}

		if (topicId != -1) {

			// Top newest post
			List<Post> topNPost = postService.getTopNewest(3, topicId);
			model.addAttribute("topPost", topNPost);

			List<String> topAuthorName = new ArrayList<>();
			for (int i = 0; i < topNPost.size(); i++) {
				topAuthorName.add(authorService.getFullName(topNPost.get(i).getAuthorId()));
			}
			model.addAttribute("topAuthorName", topAuthorName);

			// Page post
			List<Post> listPost = postService.getInRange(3, MAX_POST_PER_PAGE, topicId);
			model.addAttribute("listPost", listPost);

			List<String> listAuthorName = new ArrayList<>();
			for (int i = 0; i < listPost.size(); i++) {
				listAuthorName.add(authorService.getFullName(listPost.get(i).getAuthorId()));
			}
			model.addAttribute("listAuthorName", listAuthorName);
		}

		return "topic/topic-page";
	}

}
