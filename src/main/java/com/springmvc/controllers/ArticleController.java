package com.springmvc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.springmvc.models.*;
import com.springmvc.services.*;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	@Qualifier("postServiceImpl")
	ServiceBase<Post> postServiceBase;
	
	@Autowired
	@Qualifier("authorServiceImpl")
	ServiceBase<Author> authorServiceBase;
	
	@Autowired
	@Qualifier("postContentServiceImpl")
	ServiceBase<PostContent> postContentServiceBase;
	
	@Autowired
	@Qualifier("topicServiceImpl")
	ServiceBase<Topic> topicServiceBase;
	
	@Autowired
	TagService tagService;
	
	@Autowired
	AuthorService authorService;
	
	@ModelAttribute(name = "listTopic")
	public List<Topic> getListTopic(){
		List<Topic> listTopic = topicServiceBase.getAll();

		return listTopic;
	}
	
	@RequestMapping(value = "/{shortTitle:[a-zA-z0-9-]+}/{postId}")
	public String showPost(@PathVariable("postId") int postId, ModelMap model) {
		
		Post post = postServiceBase.getById(postId);
		PostContent postContent = postContentServiceBase.getById(post.getPostContentId());
		Topic topic = topicServiceBase.getById(post.getTopicId());
		String authorName = authorService.getFullName(post.getAuthorId());
		List<Tag> listTag = tagService.getByPostId(postId);
		
		model.addAttribute("post", post);
		model.addAttribute("content", postContent.getContent());
		model.addAttribute("listTag", listTag);
		model.addAttribute("topic", topic.getName());
		model.addAttribute("authorName", authorName);
		
		return "article/single-post";
	}
	
}
