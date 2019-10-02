package com.springmvc.models;

import com.springmvc.entities.PostContentEntity;

public class PostContent {

	private int postContentId;
	
	private int commentCount;
	
	private int upvote;
	
	private String content;
	
	public static PostContent NewPostContent(String content) {
		PostContent p = new PostContent();
		p.setCommentCount(0);
		p.setContent(content);
		p.setUpvote(0);
		p.setPostContentId(0);
		return p;
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
