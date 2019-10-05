package com.springmvc.dao;

import java.util.Map;

import com.springmvc.models.Comment;
import com.springmvc.models.UserInfo;

public interface CommentDAO extends DAOBase<Comment> {
	
	public Map<Comment, UserInfo> getByPostId(int postId);
	
}
