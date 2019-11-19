package com.springmvc.controllers;

import static com.springmvc.models.PostContent.newPostContent;
import static com.springmvc.util.CurrentLogin.id;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.models.Post;
import com.springmvc.models.PostContent;
import com.springmvc.models.Tag;
import com.springmvc.models.Topic;
import com.springmvc.services.PostContentService;
import com.springmvc.services.PostService;
import com.springmvc.services.TagService;
import com.springmvc.services.TopicService;
import com.springmvc.util.CurrentLogin;

@Controller
@RequestMapping("/author/")
public class AuthorController {

	@Autowired
	TopicService topicService;

	@Autowired
	TagService tagService;
	
	@Autowired
	PostContentService postContentService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	ServletContext context;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@ModelAttribute("listTopic")
	public List<Topic> getTopics() {
		List<Topic> listTopic = topicService.getAll();
		return listTopic;
	}
	
	@RequestMapping(value = "/add-post", method = RequestMethod.GET)
	public String addPost(ModelMap model) {

		Post p = new Post();
		model.addAttribute("newPost", p);

		return "/author/post-news";
	}

	@RequestMapping(value = "/review-post", method = RequestMethod.POST)
	public String demoPost(ModelMap model,
			@ModelAttribute("newPost") Post post,
			@RequestParam("tags") String tags,
			@RequestParam("imageHeader") MultipartFile imageHeader) {
		
		List<Tag> listTag = new ArrayList<Tag>();
		post.setTime(LocalDateTime.now());
		String tagArr[] = tags.split(",");
		for(int i = 0; i < tagArr.length; i++) {
			Tag t = new Tag();
			t.setName(tagArr[i]);
			
			listTag.add(t);
		}
		model.addAttribute("post", post);
		model.addAttribute("content", post.getContent());
		model.addAttribute("listTag", listTag);
		Topic topic = topicService.getById(post.getTopicId());
		model.addAttribute("topic", topic.getName());
		model.addAttribute("authorName", CurrentLogin.fullName);
		
		return "author/post-demo";
	}
	
	@RequestMapping(value = "/save-post", method = RequestMethod.POST)
	public String savePost(ModelMap model,
			@ModelAttribute("newPost") Post post,
			@RequestParam("tags") String tags,
			@RequestParam("imageHeader") MultipartFile imageHeader) {

		List<Tag> listTag = new ArrayList<Tag>();
		post.setTime(LocalDateTime.now());
		String tagArr[] = tags.split(",");
		for(int i = 0; i < tagArr.length; i++) {
			Tag t = new Tag();
			t.setName(tagArr[i]);
			
			listTag.add(t);
		}
		model.addAttribute("post", post);
		model.addAttribute("content", post.getContent());
		model.addAttribute("listTag", listTag);
		Topic topic = topicService.getById(post.getTopicId());
		model.addAttribute("topic", topic.getName());
		model.addAttribute("authorName", CurrentLogin.fullName);

		PostContent postContent = newPostContent(post.getContent());
		int postContentId = post.getPostContentId();
		postContent.setPostContentId(postContentId);
		
		boolean isEdit = postContentId != 0;
		
		// nếu thêm mới thì postContentId = 0
		if(!isEdit) {
			postContentId = postContentService.save(postContent);
		}else {
			postContentService.update(postContent);
		}
		
		// ======================================== save post =============================================
		String imageSavePath = "/lib/post-image/id" + postContentId + ".jpg";
		if(!imageHeader.isEmpty()) {
			try {
				String photoPath = context.getRealPath(imageSavePath);
				System.out.println(photoPath);
				File file = new File(photoPath);
				if(file.exists()) {
					file.delete();
				}
				imageHeader.transferTo(new File(photoPath));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		post = post.setPost(id, postContentId, imageSavePath);
		post.setPostContentId(postContentId);
		int postId = post.getPostId();
		if(!isEdit) {
			postId = postService.saveWithContent(post, postContent.getContent());
		}else {
			postService.update(post);
		}
		//===================================================================================================
		
		// ======================= save tags ===========================
		for (int i = 0; i < tagArr.length; i++) {
			Tag tag = new Tag();
			tag.setName(tagArr[i]);
			tag.setTagId(0);
			
			postService.saveTags(postId, tagService.save(tag));
		}
		// =============================================================

		return "author/post-demo";
	}
	
	@RequestMapping("/dashboard")
	public String dashBoard(ModelMap model) {
		
		
//		if(CurrentLogin.roles.get(0).getRoleName().equals("AUTHOR")) {
//			List<Post> list = postService.getByAuthorId(CurrentLogin.id);
//			model.addAttribute("listPost", list);
//			
//			List<String> topicName = new ArrayList<String>();
//			for(Post item : list) {
//				topicName.add(topicService.getById(item.getTopicId()).getName());
//			}
//			model.addAttribute("listTopicName", topicName);
//			
//			return "author/dashboard";
//		}
		
		return "author/dashboard";
	}
	
	@RequestMapping("/list-post")
	public String list(ModelMap model) {
		
		List<Post> list = postService.getByAuthorId(CurrentLogin.id);
		model.addAttribute("listPost", list);
		
		List<String> topicName = new ArrayList<String>();
		for(Post item : list) {
			topicName.add(topicService.getById(item.getTopicId()).getName());
		}
		model.addAttribute("listTopicName", topicName);
		
		return "author/list-post";
	}
	
	@RequestMapping("/editPost/{id:\\d+}")
	public String edit(ModelMap model, @PathVariable("id") int postId) {
		
		Post postEdit = postService.getById(postId);
		model.addAttribute("newPost", postEdit);
		
		return "author/post-news";
	}
	
	@RequestMapping(value = "/deletePost", method = RequestMethod.GET)
	@ResponseBody
	public String delete(ModelMap model, @RequestParam int postId) {
		
		boolean result = postService.deleteById(postId);
		
		return result ? "true" : "false";
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
}
