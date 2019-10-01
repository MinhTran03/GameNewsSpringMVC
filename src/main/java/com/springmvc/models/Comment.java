package com.springmvc.models;

import java.time.LocalDate;

public class Comment {
	
	private int commentId;
	
	private String content;
	
	private int like;
	
	private LocalDate time;
	
	private int postId;
	
	private int userId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
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
	
}
