package com.springmvc.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ParameterMode;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springmvc.entities.*;
import com.springmvc.models.*;

@Repository
public class TagDAOImpl implements DAOBase<Tag>, TagDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Tag> getAll() {
		List<Tag> listTag = new ArrayList<Tag>();

		try {
			Session session = sessionFactory.getCurrentSession();

			Query<TagEntity> query = session.createQuery("From TagEntity", TagEntity.class);
			
			List<TagEntity> listTE = query.list();
			
			for (int i = 0; i < listTE.size(); i++) {
				Tag tag = new Tag();
				tag.entity2model(listTE.get(i));
				listTag.add(tag);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listTag;
	}

	@Override
	public Tag getById(int id) {
		return null;
	}

	@Override
	public boolean save(Tag entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Tag entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Tag entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tag> getByPostId(int postId) {
		List<Tag> listTag = new ArrayList<>();
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			ProcedureCall spQuery = session.createStoredProcedureCall("sp_Tag_getByPost", TagEntity.class);
			spQuery.registerParameter("postId", Integer.class, ParameterMode.IN).bindValue(postId);
			
			@SuppressWarnings("unchecked")
			List<TagEntity> listTE = (List<TagEntity>)spQuery.getResultList();
			
			for (int i = 0; i < listTE.size(); i++) {
				Tag tag = new Tag();
				tag.entity2model(listTE.get(i));
				listTag.add(tag);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTag;
	}

}
