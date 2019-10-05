package com.springmvc.models;

import javax.validation.constraints.NotNull;

import com.springmvc.entities.PostContentEntity;

public class PostContent {

	private int postContentId;
	
	private int commentCount;
	
	private int upvote;
	
	@NotNull(message = "Content can not empty")
	private String content;
	
	private int postId;
	
	public PostContent() {
		super();
		this.postContentId = 0;
		this.commentCount = 0;
		this.upvote = 0;
	}

	public static PostContent newPostContent(String content) {
		PostContent p = new PostContent();
		p.setContent(content);
		return p;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getPostContentId() {
		return postContentId;
	}

	public void setPostContentId(int postContentId) {
		this.postContentId = postContentId;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void entity2model(PostContentEntity entity) {
		this.setCommentCount(entity.getComment_count());
		this.setContent(entity.getContent());
		this.setPostContentId(entity.getPost_content_id());
		this.setUpvote(entity.getUpvote());
	}
}
