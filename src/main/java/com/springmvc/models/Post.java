package com.springmvc.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.springmvc.entities.PostEntity;

public class Post {

	public final static int SHORT_TITLE_LENGTH = 40;
	
	private String content;
	private int postId;
	private int userId;
	private int topicId;
	private int postContentId;
	private String title;
	private String description;
	private String image;
	private int views;
	private LocalDateTime time;
	private String shortTitle;
	private boolean status;
	private List<Tag> listTag;
	
	public Post() {
		super();
		this.views = 0;
	}

	public Post setPost(int userId, int postContentId, String imagePath) {
		String title = this.getTitle();
		
		this.setPostContentId(postContentId);
		this.setImage(imagePath);
		this.setUserId(userId);
		this.setTopicId(topicId);
		
		this.setTime(LocalDateTime.now());
		this.setShortTitle(title.toLowerCase().
								substring(0, title.length() < SHORT_TITLE_LENGTH ? title.length() : SHORT_TITLE_LENGTH).
								replaceAll("[ \"]", "-"));
		this.setStatus(false);
		this.listTag = new ArrayList<Tag>();
		return this;
	}
	
	public List<Tag> getListTag() {
		return listTag;
	}

	public void setListTag(List<Tag> listTag) {
		this.listTag = listTag;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getPostContentId() {
		return postContentId;
	}

	public void setPostContentId(int postContentId) {
		this.postContentId = postContentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getStringTime() {
		return time.format(DateTimeFormatter.ofPattern("dd MMM, yyyy"));
	}
	
	public void entity2model(PostEntity entity) {
		this.setUserId(entity.getUser().getUser_id());
		this.setDescription(entity.getDescription());
		this.setPostId(entity.getPost_id());
		this.setTime(entity.getTime());
		this.setTitle(entity.getTitle());
		this.setTopicId(entity.getTopic().getTopic_id());
		this.setViews(entity.getViews());
		this.setImage(entity.getImage());
		this.setPostContentId(entity.getPostContent().getPost_content_id());
		this.setShortTitle(entity.getShort_title());
		this.setStatus(entity.getStatus());
		this.setContent(entity.getPostContent().getContent());
	}
	
}
