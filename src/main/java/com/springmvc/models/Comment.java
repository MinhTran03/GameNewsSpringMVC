package com.springmvc.models;

import java.time.LocalDateTime;

import com.springmvc.entities.CommentEntity;

public class Comment {
	
	private int commentId;
	private String content;
	private int like;
	private LocalDateTime time;
	private int postId;
	private int userId;

	public static Comment newComment(String content, int postId, int userId) {
		Comment comment = new Comment();
		
		comment.setCommentId(0);
		comment.setContent(content);
		comment.setLike(0);
		comment.setPostId(postId);
		comment.setTime(LocalDateTime.now());
		comment.setUserId(userId);
		
		return comment;
	}
	
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

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
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
	
	public void entity2model(CommentEntity entity) {
		this.setCommentId(entity.getComment_id());
		this.setContent(entity.getContent());
		this.setLike(entity.getLike());
		this.setPostId(entity.getPost().getPost_id());
		this.setTime(entity.getTime());
		this.setUserId(entity.getUser().getUser_id());
	}
}
