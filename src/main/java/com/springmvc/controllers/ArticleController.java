package com.springmvc.controllers;

import static com.springmvc.models.Comment.newComment;
import static com.springmvc.util.CurrentLogin.id;
import static com.springmvc.util.CurrentLogin.loggingIn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.models.Comment;
import com.springmvc.models.Post;
import com.springmvc.models.PostContent;
import com.springmvc.models.Tag;
import com.springmvc.models.Topic;
import com.springmvc.models.UserInfo;
import com.springmvc.services.CommentService;
import com.springmvc.services.PostContentService;
import com.springmvc.services.PostService;
import com.springmvc.services.TagService;
import com.springmvc.services.TopicService;
import com.springmvc.services.UserService;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostContentService postContentService;
	
	@Autowired
	TopicService topicServiceBase;
	
	@Autowired
	TagService tagService;
	
	@Autowired
	CommentService commentService;
	
	@ModelAttribute(name = "listTopic")
	public List<Topic> getListTopic(){
		List<Topic> listTopic = topicServiceBase.getAll();

		return listTopic;
	}
	
	@RequestMapping(value = "/{shortTitle:[\\w\\W]+}/{postId}")
	public String showPost(@PathVariable int postId, ModelMap model) {
		
		// ==================================== LOAD CONTENT ===============================
		Post post = postService.getById(postId);
		PostContent postContent = postContentService.getById(post.getPostContentId());
		Topic topic = topicServiceBase.getById(post.getTopicId());
		String authorName = userService.getFullName(post.getUserId());
		List<Tag> listTag = tagService.getByPostId(postId);
		
		model.addAttribute("loggingIn", loggingIn);
		model.addAttribute("post", post);
		model.addAttribute("content", postContent.getContent());
		model.addAttribute("listTag", listTag);
		model.addAttribute("topic", topic.getName());
		model.addAttribute("authorName", authorName);
		// ===================================================================================
		
		// ================================== LOAD COMMENT ====================================
		Map<Comment, UserInfo> commentInfo = commentService.getByPostId(postId);
		List<Comment> comments = new ArrayList<Comment>(commentInfo.keySet());
		List<UserInfo> users = new ArrayList<UserInfo>(commentInfo.values());
		model.addAttribute("listComment", comments);
		model.addAttribute("listUser", users);
		// ====================================================================================
		
		return "article/single-post";
	}
	
	@RequestMapping(value = "/{shortTitle:[\\w\\W]+}/comment", method = RequestMethod.GET)
	@ResponseBody
	public String postCommentLogin(ModelMap model,
								@RequestParam int postId,
								@RequestParam String content) {
		
		Comment comment = newComment(content, postId, id);
		int cmId = commentService.save(comment);
		
		Map<String, String> json = new HashMap<String, String>();
		if(cmId != -1) {
			UserInfo user = userService.getById(id);
			json.put("imageSrc", user.getImage());
			json.put("name", user.getFirstName() + ' ' + user.getLastName());
			json.put("valid", "1");
		}else {
			json.put("valid", "0");
		}
		
		String jsonAsString = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			jsonAsString = mapper.writeValueAsString(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonAsString;
	}
	
	@RequestMapping(value = "/{shortTitle:[\\w\\W]+}/commentWithoutLogin", method = RequestMethod.GET)
	@ResponseBody
	public String postCommentNotLogin(ModelMap model,
								@RequestParam String name,
								@RequestParam String email,
								@RequestParam int postId,
								@RequestParam String content) {
		
//		// Kiểm tra thông tin user
//		List<Role> listRole = userService.checkLogin(userLogin.getEmail(), userLogin.getPassword());
//		
//		if(listRole == null) {
//			// login fail
//			model.addAttribute("message", "Login fail");
//			return "login/login-page";
//		}else {
//			loggingIn = true;
//			userName = userLogin.getEmail();
//			roles = listRole;
//			id = userService.getIdByEmail(userName);
//			System.out.println(id);
//			
//			listRole.forEach(item -> {
//				System.out.println(item.getRoleId());
//				System.out.println(item.getRoleName());
//			});
//		}
		
		Comment comment = newComment(content, postId, id);
		int cmId = commentService.save(comment);
		
		Map<String, String> json = new HashMap<String, String>();
		if(cmId != -1) {
			UserInfo user = userService.getById(id);
			json.put("imageSrc", user.getImage());
			json.put("name", user.getFirstName() + ' ' + user.getLastName());
			json.put("valid", "1");
		}else {
			json.put("valid", "0");
		}
		
		String jsonAsString = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			jsonAsString = mapper.writeValueAsString(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonAsString;
	}
}
