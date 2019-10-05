package com.springmvc.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReplyComment")
public class ReplyCommentEntity {
	
	@Id
	@Column(name = "reply_comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reply_comment_id;
	
	@Column(nullable = false)
	private String content;
	
	@Column(name = "[like]", nullable = false)
	private int like;
	
	@Column(nullable = false)
	private LocalDateTime time;
	
	//-------------------------------------------------------
	
	@ManyToOne
	@JoinColumn(name = "comment_id")
	private CommentEntity comment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	//-------------------------------------------------------
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public CommentEntity getComment() {
		return comment;
	}
	public void setComment(CommentEntity comment) {
		this.comment = comment;
	}
	public int getReply_comment_id() {
		return reply_comment_id;
	}
	public void setReply_comment_id(int reply_comment_id) {
		this.reply_comment_id = reply_comment_id;
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

}
