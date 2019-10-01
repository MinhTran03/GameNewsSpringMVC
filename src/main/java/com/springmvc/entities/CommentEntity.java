package com.springmvc.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class CommentEntity {
	
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_id;
	
	@Column(nullable = false)
	private String content;
	
	@Column(name = "[like]", nullable = false)
	private int like;
	
	@Column(nullable = false)
	private LocalDate time;
	
	//-------------------------------------------------------------
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private PostEntity post;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "comment")
	private Set<ReplyCommentEntity> replyComments;
	
	//-------------------------------------------------------------
	
	public Set<ReplyCommentEntity> getReplyComments() {
		return replyComments;
	}
	public void setReplyComments(Set<ReplyCommentEntity> replyComments) {
		this.replyComments = replyComments;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public PostEntity getPost() {
		return post;
	}
	public void setPost(PostEntity post) {
		this.post = post;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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
