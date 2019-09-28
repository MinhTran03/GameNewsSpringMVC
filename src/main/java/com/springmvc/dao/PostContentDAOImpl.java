package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.PostContentEntity;
import com.springmvc.models.*;

@Repository
public class PostContentDAOImpl implements DAOBase<PostContent>{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PostContent> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostContent getById(int id) {
		PostContent content = new PostContent();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			PostContentEntity contentEntity = session.get(PostContentEntity.class, id);
			
			content.entity2model(contentEntity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return content;
	}

	@Override
	public boolean save(PostContent entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PostContent entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PostContent entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
