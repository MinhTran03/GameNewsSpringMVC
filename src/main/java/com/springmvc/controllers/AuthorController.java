package com.springmvc.controllers;

import static com.springmvc.models.Post.NewPost;
import static com.springmvc.models.PostContent.NewPostContent;
import static com.springmvc.util.CurrentLogin.id;
import static com.springmvc.util.CurrentLogin.loggingIn;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.models.Post;
import com.springmvc.models.PostContent;
import com.springmvc.models.Tag;
import com.springmvc.models.Topic;
import com.springmvc.services.PostContentService;
import com.springmvc.services.PostService;
import com.springmvc.services.TagService;
import com.springmvc.services.TopicService;

@Controller
@RequestMapping("/author")
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

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post(ModelMap model) {

		if (loggingIn == false) {
			return "redirect:/login/";
		}
		
		List<Tag> listTag = tagService.getAll();
		model.addAttribute("listTag", listTag);

		List<Topic> listTopic = topicService.getAll();
		model.addAttribute("listTopic", listTopic);

		return "author/post-news";
	}

	@RequestMapping(value = "/demo-post", method = RequestMethod.POST)
	public String demoPost(ModelMap model, 
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam String tags,
			@RequestParam String topic,
			@RequestParam String description,
			@RequestParam MultipartFile imageHeader) {

		String tagArr[] = tags.split(",");

		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("tagList", tagArr);
		model.addAttribute("topic", topic);
		
		// =============== save content ==========================
		PostContent postContent = NewPostContent(content);
		int postContentId = postContentService.save(postContent);
		//========================================================
		
		// ================= save post ====================================================================
		String imageSavePath = "/lib/post-image/id" + postContentId + ".jpg";
		try {
			String photoPath = context.getRealPath(imageSavePath);
			System.out.println(photoPath);
			imageHeader.transferTo(new File(photoPath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Post post = NewPost(title, description, id, Integer.parseInt(topic), postContentId, imageSavePath);
		int postId = postService.save(post);
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

}
