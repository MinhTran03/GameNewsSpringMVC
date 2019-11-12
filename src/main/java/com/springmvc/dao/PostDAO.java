package com.springmvc.dao;

import java.util.List;
import com.springmvc.models.*;

public interface PostDAO extends DAOBase<Post> {

	public List<Post> getTopNewest(int top, int topicId);
	
	public List<Post> getInRange(int skip, int take, int topicId);
	
	public boolean saveTags(int postId, int tagId);
	
	public int count(int topicId);
	
	public int saveWithContent(Post post, String postContent);
	
	public boolean increaseViews(int postId);
	
	public List<Post> getByAuthorId(int id);
	
	public boolean deleteById(int id);
}
