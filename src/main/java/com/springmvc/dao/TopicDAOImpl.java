package com.springmvc.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springmvc.entities.*;
import com.springmvc.models.*;

@Repository
public class TopicDAOImpl implements TopicDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Topic> getAll() {
		List<Topic> listTopic = new ArrayList<Topic>();

		try {
			Session session = sessionFactory.getCurrentSession();

			Query<TopicEntity> query = session.createQuery("From TopicEntity", TopicEntity.class);
			
			List<TopicEntity> listTPE = query.list();

			for (int i = 0; i < listTPE.size(); i++) {
				Topic topic = new Topic();
				topic.entity2model(listTPE.get(i));
				listTopic.add(topic);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listTopic;
	}

	@Override
	public Topic getById(int id) {
		Topic topic = new Topic();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			TopicEntity topicEntity = (TopicEntity) session.get(TopicEntity.class, id);
			topic.entity2model(topicEntity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return topic;
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
