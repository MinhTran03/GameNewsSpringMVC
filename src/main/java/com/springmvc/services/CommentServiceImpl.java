package com.springmvc.services;

import java.util.List;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.springmvc.models.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Override
	@Transactional
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Comment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int save(Comment entity) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	@Transactional
	public boolean update(Comment entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean delete(Comment entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
