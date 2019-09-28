package com.springmvc.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.springmvc.entities.PostEntity;

public class Post {

	private int postId;
	
	private int authorId;
	
	private int topicId;
	
	private int postContentId;
	
	private String title;
	
	private String description;
	
	private String image;
	
	private int views;
	
	private LocalDate time;
	
	private String shortTitle;
	
	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPostContentId() {
		return postContentId;
	}

	public void setPostContentId(int postContentId) {
		this.postContentId = postContentId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	
	public String getStringTime() {
		return time.format(DateTimeFormatter.ofPattern("dd MMM,yyyy"));
	}
	
	public void entity2model(PostEntity entity) {
		this.setAuthorId(entity.getAuthor().getAuthor_id());
		this.setDescription(entity.getDescription());
		this.setPostId(entity.getPost_id());
		this.setTime(entity.getTime());
		this.setTitle(entity.getTitle());
		this.setTopicId(entity.getTopic().getTopic_id());
		this.setViews(entity.getViews());
		this.setImage(entity.getImage());
		this.setPostContentId(entity.getPostContentEntity().getPost_content_id());
		this.setShortTitle(entity.getShortTitle());
	}
	
}
