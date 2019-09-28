package com.springmvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PostContent")
public class PostContentEntity {
	
	@Id
	@Column(name = "post_content_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int post_content_id;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private int comment_count;
	
	@Column(nullable = false)
	private int upvote;
	
	//----------------------------------------------------------------
	
	@OneToOne(mappedBy = "postContent")
    private PostEntity post;
	
	//----------------------------------------------------------------

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}

	public int getPost_content_id() {
		return post_content_id;
	}

	public void setPost_content_id(int post_content_id) {
		this.post_content_id = post_content_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}
}
