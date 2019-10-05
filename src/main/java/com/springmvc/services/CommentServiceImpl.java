package com.springmvc.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.springmvc.dao.CommentDAO;
import com.springmvc.models.Comment;
import com.springmvc.models.UserInfo;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO commentDao;
	
	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Comment object) {
		// TODO Auto-generated method stub
		return commentDao.save(object);
	}

	@Override
	public boolean update(Comment entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Comment entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Comment, UserInfo> getByPostId(int postId) {
		// TODO Auto-generated method stub
		return commentDao.getByPostId(postId);
	}

}
