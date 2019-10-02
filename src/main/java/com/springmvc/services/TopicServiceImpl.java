package com.springmvc.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.dao.DAOBase;
import com.springmvc.models.*;

@Service
@Transactional
public class TopicServiceImpl implements TopicService{

	@Autowired
	DAOBase<Topic> topicDAO;
	
	@Override
	public List<Topic> getAll() {
		// TODO Auto-generated method stub
		return topicDAO.getAll();
	}

	@Override
	public Topic getById(int id) {
		// TODO Auto-generated method stub
		return topicDAO.getById(id);
	}

	@Override
	public int save(Topic entity) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean update(Topic entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Topic entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
