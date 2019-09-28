package com.springmvc.models;

import java.time.LocalDate;

public class ReplyComment {
	
	private int replyCommentId;
	
	private String content;
	
	private int like;
	
	private LocalDate time;
	
	private int commentId;
	
	private int reader_id;

	public int getReader_id() {
		return reader_id;
	}

	public void setReader_id(int reader_id) {
		this.reader_id = reader_id;
	}

	public int getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(int replyCommentId) {
		this.replyCommentId = replyCommentId;
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

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	

}
