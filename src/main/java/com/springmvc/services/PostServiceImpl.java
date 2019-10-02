package com.springmvc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.springmvc.dao.PostDAO;
import com.springmvc.models.*;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	PostDAO postDAO;
	
	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getById(int id) {
		return postDAO.getById(id);
	}

	@Override
	public int save(Post entity) {
		// TODO Auto-generated method stub
		return postDAO.save(entity);
	}

	@Override
	public boolean update(Post entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Post entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Post> getTopNewest(int top, int topicId) {
		return postDAO.getTopNewest(top, topicId);
	}

	@Override
	public List<Post> getInRange(int skip, int take, int topicId) {
		return postDAO.getInRange(skip, take, topicId);
	}

	@Override
	public boolean saveTags(int postId, int tagId) {
		// TODO Auto-generated method stub
		return postDAO.saveTags(postId, tagId);
	}

}
