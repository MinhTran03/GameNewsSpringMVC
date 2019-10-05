package com.springmvc.services;

import java.util.Map;

import com.springmvc.models.Comment;
import com.springmvc.models.UserInfo;

public interface CommentService extends ServiceBase<Comment> {
	public Map<Comment, UserInfo> getByPostId(int postId);
}
