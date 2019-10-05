package com.springmvc.dao;

import static com.springmvc.entities.CommentEntity.newEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.CommentEntity;
import com.springmvc.models.Comment;
import com.springmvc.models.UserInfo;

@Repository
public class CommentDAOImpl implements CommentDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Comment> getAll() {
		return null;
	}

	@Override
	public Comment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Comment object) {
		int id = -1;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			CommentEntity entity = newEntity(object); 
			
			session.save(entity);
			
			id = entity.getComment_id();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public boolean update(Comment object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Comment object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Comment, UserInfo> getByPostId(int postId) {
		Map<Comment, UserInfo> listComment = new HashMap<>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			ProcedureCall spQuery = session.createStoredProcedureCall("sp_Comment_getByPostId", CommentEntity.class);
			spQuery.registerParameter("postId", Integer.class, ParameterMode.IN).bindValue(postId);
			
			@SuppressWarnings("unchecked")
			List<CommentEntity> listCE = (List<CommentEntity>) spQuery.getResultList();
			
			listCE.forEach((entity) -> {
				Comment comment = new Comment();
				comment.entity2model(entity);
				UserInfo user = new UserInfo();
				user.entity2modelMode(entity.getUser());
				listComment.put(comment, user);
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listComment;
	}

}
