package com.springmvc.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ParameterMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springmvc.entities.*;
import com.springmvc.models.*;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getById(int id) {
		Post post = new Post();

		try {
			Session session = sessionFactory.getCurrentSession();

			PostEntity postEntity = (PostEntity) session.get(PostEntity.class, id);

			post.entity2model(postEntity);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return post;
	}

	@Override
	public int save(Post entity) {
		int result = -1;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			ProcedureCall spQuery = session.createStoredProcedureCall("sp_Post_insert");
			spQuery.registerParameter("topicId", Integer.class, ParameterMode.IN).bindValue(entity.getTopicId());
			spQuery.registerParameter("contentId", Integer.class, ParameterMode.IN).bindValue(entity.getPostContentId());
			spQuery.registerParameter("title", String.class, ParameterMode.IN).bindValue(entity.getTitle());
			spQuery.registerParameter("description", String.class, ParameterMode.IN).bindValue(entity.getDescription());
			spQuery.registerParameter("image", String.class, ParameterMode.IN).bindValue(entity.getImage());
			spQuery.registerParameter("views", Integer.class, ParameterMode.IN).bindValue(entity.getViews());
			spQuery.registerParameter("time", LocalDate.class, ParameterMode.IN).bindValue(entity.getTime());
			spQuery.registerParameter("shortTitle", String.class, ParameterMode.IN).bindValue(entity.getShortTitle());
			spQuery.registerParameter("userId", Integer.class, ParameterMode.IN).bindValue(entity.getUserId());
			
			result = (int)spQuery.getResultList().get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean update(Post entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Post entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Post> getTopNewest(int top, int topicId) {
		List<Post> listPost = new ArrayList<Post>();

		try {
			Session session = sessionFactory.getCurrentSession();

			ProcedureCall spQuery = session.createStoredProcedureCall("sp_Post_getTopNewest", PostEntity.class);
			spQuery.registerParameter("top", Integer.class, ParameterMode.IN).bindValue(top);
			spQuery.registerParameter("topicId", Integer.class, ParameterMode.IN).bindValue(topicId);
			
			@SuppressWarnings("unchecked")
			List<PostEntity> listPOE = (List<PostEntity>) spQuery.getResultList();
			
			for (int i = 0; i < listPOE.size(); i++) {
				Post post = new Post();
				post.entity2model(listPOE.get(i));
				listPost.add(post);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listPost;
	}

	@Override
	public List<Post> getInRange(int skip, int take, int topicId) {
		List<Post> listPost = new ArrayList<Post>();

		try {
			Session session = sessionFactory.getCurrentSession();

			ProcedureCall spQuery = session.createStoredProcedureCall("sp_Post_getInRange", PostEntity.class);
			spQuery.registerParameter("skip", Integer.class, ParameterMode.IN).bindValue(skip);
			spQuery.registerParameter("take", Integer.class, ParameterMode.IN).bindValue(take);
			spQuery.registerParameter("topic", Integer.class, ParameterMode.IN).bindValue(topicId);
			
			@SuppressWarnings("unchecked")
			List<PostEntity> listPOE = (List<PostEntity>) spQuery.getResultList();

			for (int i = 0; i < listPOE.size(); i++) {
				Post post = new Post();
				post.entity2model(listPOE.get(i));
				listPost.add(post);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listPost;
	}

	@Override
	public boolean saveTags(int postId, int tagId) {
		try {
			Session session = sessionFactory.getCurrentSession();

			ProcedureCall spQuery = session.createStoredProcedureCall("sp_TagPost_insert");
			spQuery.registerParameter("postId", Integer.class, ParameterMode.IN).bindValue(postId);
			spQuery.registerParameter("tagId", Integer.class, ParameterMode.IN).bindValue(tagId);
			
			spQuery.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
