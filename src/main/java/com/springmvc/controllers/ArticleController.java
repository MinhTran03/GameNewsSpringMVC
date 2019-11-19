package com.springmvc.controllers;

import static com.springmvc.models.Comment.newComment;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import com.springmvc.util.PasswordGenerator;

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

	@Autowired
	JavaMailSender mailer;

	@ModelAttribute(name = "listTopic")
	public List<Topic> getListTopic() {
		List<Topic> listTopic = topicServiceBase.getAll();

		return listTopic;
	}

	@RequestMapping(value = {"/{shortTitle:[\\w\\W]+}/{postId:\\d+}*", "/{shortTitle:[\\\\w\\\\W]+}/{postId:\\\\d+}/*"})
	public String showPost(@PathVariable int postId, ModelMap model, HttpSession httpSession) {

		UserInfo currentUser = (UserInfo)httpSession.getAttribute("current_user");
		
		// ==================================== LOAD CONTENT
		// ===============================
		Post post = postService.getById(postId);
		if(post == null) {
			return "fileNotFound";
		}
		
		postService.increaseViews(postId);
		PostContent postContent = postContentService.getById(post.getPostContentId());
		Topic topic = topicServiceBase.getById(post.getTopicId());
		String authorName = userService.getFullName(post.getUserId());
		List<Tag> listTag = tagService.getByPostId(postId);

		model.addAttribute("loggingIn", currentUser != null);
		model.addAttribute("post", post);
		model.addAttribute("content", postContent.getContent());
		model.addAttribute("listTag", listTag);
		model.addAttribute("topic", topic.getName());
		model.addAttribute("authorName", authorName);
		model.addAttribute("authorId", post.getUserId());
		// ===================================================================================

		// ================================== LOAD COMMENT
		// ====================================
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
	public String postCommentLogin(@RequestParam int postId, @RequestParam String content, HttpSession httpSession) {

		UserInfo currentUser = (UserInfo)httpSession.getAttribute("current_user");
		
		Comment comment = newComment(content, postId, currentUser.getUserId());
		int cmId = commentService.save(comment);

		Map<String, String> json = new HashMap<String, String>();
		if (cmId != -1) {
			UserInfo user = userService.getById(currentUser.getUserId());
			json.put("imageSrc", user.getImage());
			json.put("name", user.getFirstName() + ' ' + user.getLastName());
			json.put("valid", "1");
		} else {
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

	public UserInfo newUserCommentHander(UserInfo user, String name, String email) {
		
		// User chưa có => tạo mới => gửi pass tới email đó
		user.setRegistrationDay(LocalDate.now());
		user.setLastName(name);
		user.setTotalPost(0);
		user.setEmail(email);

		// Tạo password ngẫu nhiên
		PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder().useDigits(true)
				.useLower(true).useUpper(true).build();
		String password = passwordGenerator.generate(8);
		user.setPassword(password);

		// Gửi password tới email đăng ký
		sendMail(email, "Game News send password", "Username: " + email + "\nPassword: " + password);

		// Lưu user xuống csdl
		user.setUserId(userService.save(user));
		return user;
	}

	public boolean sendMail(String to, String subject, String body) {
		try {
			// tạo mail
			MimeMessage mail = mailer.createMimeMessage();

			// sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			String from = "tranconminh503@gmail.com";
			helper.setFrom(from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);

			mailer.send(mail);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
}
