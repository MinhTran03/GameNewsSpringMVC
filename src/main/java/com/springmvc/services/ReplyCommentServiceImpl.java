package com.springmvc.services;

import java.util.List;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.springmvc.models.ReplyComment;

@Service
public class ReplyCommentServiceImpl implements ServiceBase<ReplyComment> {

	@Override
	@Transactional
	public List<ReplyComment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ReplyComment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean save(ReplyComment entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean update(ReplyComment entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean delete(ReplyComment entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
