package com.springmvc.dao;

import static com.springmvc.entities.PostContentEntity.newEntity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.PostContentEntity;
import com.springmvc.models.PostContent;
@Repository
public class PostContentDAOImpl implements PostContentDAO{

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
	public int save(PostContent object) {
		int id = -1;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			PostContentEntity p = newEntity(object);
			
			session.save(p);
			
			id = p.getPost_content_id();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean update(PostContent object) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			PostContentEntity p = newEntity(object);
			p.setPost_content_id(object.getPostContentId());
			
			session.update(p);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(PostContent object) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
