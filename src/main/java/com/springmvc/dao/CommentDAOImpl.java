package com.springmvc.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.springmvc.models.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO{

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
	public boolean save(Comment entity) {
		// TODO Auto-generated method stub
		return false;
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

}
