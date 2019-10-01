package com.springmvc.entities;

import java.time.LocalDate;
import javax.persistence.*;

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
	private LocalDate time;
	
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
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	} 

}
