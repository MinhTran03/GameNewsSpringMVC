package com.springmvc.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Reader")
public class ReaderEntity {
	
	@Id
	@Column(name = "reader_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reader_id;
	
	@Column(nullable = false)
	private String full_name;
	
	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private LocalDate registration_date;
	
	//-----------------------------------------------------------------------------------
	
	@OneToMany(mappedBy = "reader")
	private Set<CommentEntity> comments;
	
	@OneToMany(mappedBy = "reader")
	private Set<ReplyCommentEntity> reply_comments;
	
	//-----------------------------------------------------------------------------------
	
	public Set<ReplyCommentEntity> getReply_comments() {
		return reply_comments;
	}
	public void setReply_comments(Set<ReplyCommentEntity> reply_comments) {
		this.reply_comments = reply_comments;
	}
	public Set<CommentEntity> getComments() {
		return comments;
	}
	public void setComments(Set<CommentEntity> comments) {
		this.comments = comments;
	}
	public int getReader_id() {
		return reader_id;
	}
	public void setReader_id(int reader_id) {
		this.reader_id = reader_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(LocalDate registration_date) {
		this.registration_date = registration_date;
	}

}
