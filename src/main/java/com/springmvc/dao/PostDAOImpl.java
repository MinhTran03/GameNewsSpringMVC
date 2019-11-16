package com.springmvc.dao;

import static com.springmvc.entities.PostEntity.newEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.PostEntity;
import com.springmvc.entities.TagEntity;
import com.springmvc.entities.UserEntity;
import com.springmvc.models.Post;
import com.springmvc.models.Tag;
import com.springmvc.util.CurrentLogin;
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
			
			List<TagEntity> listTE = (List<TagEntity>) session.createNativeQuery("SELECT * FROM dbo.Tag WHERE tag_id IN (SELECT tag_id FROM dbo.Post_Tag WHERE post_id = " + id + ")", TagEntity.class).list();
			
			List<Tag> listTag = new ArrayList<Tag>();
			for (int i = 0; i < listTE.size(); i++) {
				Tag tag = new Tag();
				tag.entity2model(listTE.get(i));
				listTag.add(tag);
			}
			
			post.setListTag(listTag);
			post.entity2model(postEntity);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			post = null;
		}
		return post;
	}

	@Override
	public int save(Post object) {
		int id = -1;
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			
//			PostEntity postEntity = newEntity(object);
//			
//			session.save(postEntity);
//			
//			id = postEntity.getPost_id();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return id;
	}

	@Override
	public boolean update(Post object) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			PostEntity postEntity = newEntity(object, object.getContent());
			
			session.update(postEntity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Post object) {
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

	@Override
	public int count(int topicId) {
		int count = -1;
		try {
			Session session = sessionFactory.getCurrentSession();

			ProcedureCall spQuery = session.createStoredProcedureCall("sp_Post_countAccorTopic");
			spQuery.registerParameter("topicId", Integer.class, ParameterMode.IN).bindValue(topicId);
			
			count = (int)spQuery.getResultList().get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}

	@Override
	public int saveWithContent(Post post, String postContent) {
		int id = -1;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			PostEntity postEntity = newEntity(post, postContent);
			
			session.save(postEntity);
			
			
			id = postEntity.getPost_id();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean increaseViews(int postId) {
		boolean flag = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			Query query = session.createSQLQuery("UPDATE Post SET views = views + 1 WHERE post_id = " + postId);
			
			query.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<Post> getByAuthorId(int id){
		List<Post> list = new ArrayList<Post>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
//			Query query = session.createSQLQuery("select * from Post where user_id = " + id);
			Query query = session.createNativeQuery("select * from Post where user_id = " + id + " ORDER BY time desc", PostEntity.class);
			
			@SuppressWarnings("unchecked")
			List<PostEntity> listE = (List<PostEntity>)query.getResultList();
			
			for(PostEntity item : listE) {
				Post p = new Post();
				p.entity2model(item);
				list.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		
		return list;
	}
	
	@Override
	public List<Post> getAllNotConfirm(){
		List<Post> list = new ArrayList<Post>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			Query query = session.createNativeQuery("select * from Post where status = " + 0 + " ORDER BY time", PostEntity.class);
			
			@SuppressWarnings("unchecked")
			List<PostEntity> listE = (List<PostEntity>)query.getResultList();
			
			for(PostEntity item : listE) {
				Post p = new Post();
				p.entity2model(item);
				list.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		
		return list;
	}
	
	@Override
	public boolean deleteById(int id) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			Post p = this.getById(id);
			
			int result = -1;
			if(p != null) {
				result = session.createNativeQuery("DELETE FROM dbo.Post_Tag WHERE post_id = " + id).executeUpdate();
				result = session.createNativeQuery("DELETE FROM dbo.Post WHERE post_id = " + id).executeUpdate();				
				result = session.createNativeQuery("DELETE FROM dbo.PostContent WHERE post_content_id = " + p.getPostContentId()).executeUpdate();
				result = session.createNativeQuery("UPDATE dbo.[User] SET total_post = total_post - 1 WHERE USER_ID = " + CurrentLogin.id).executeUpdate();
			}
			
			
			return result == 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean acceptPost(int postId, int authorId) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			PostEntity p = session.get(PostEntity.class, postId);
			p.setStatus(true);
			session.update(p);
			
			UserEntity u = session.get(UserEntity.class, authorId);
			u.setTotal_post(u.getTotal_post() + 1);
			session.update(u);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Override
	public List<Post> getByTag(String tagName){
		List<Post> list = new ArrayList<Post>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
//			Query query = session.createSQLQuery("select * from Post where user_id = " + id);
			Query query = session.createNativeQuery("SELECT * FROM dbo.Post WHERE post_id IN (SELECT post_id FROM dbo.Post_Tag WHERE tag_id = (SELECT tag_id FROM dbo.Tag WHERE name = '" + tagName + "'))", PostEntity.class);
			
			@SuppressWarnings("unchecked")
			List<PostEntity> listE = (List<PostEntity>)query.getResultList();
			
			for(PostEntity item : listE) {
				Post p = new Post();
				p.entity2model(item);
				list.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		
		return list;
	}
	
	public List<Post> search(String keyword){
		
		List<Post> list = new ArrayList<Post>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
//			Query query = session.createSQLQuery("select * from Post where user_id = " + id);
			Query query = session.createNativeQuery("SELECT * FROM dbo.Post WHERE (title LIKE '%" + keyword + "%' OR description LIKE '%" + keyword + "%') AND status = 1", PostEntity.class);
			
			@SuppressWarnings("unchecked")
			List<PostEntity> listE = (List<PostEntity>)query.getResultList();
			
			for(PostEntity item : listE) {
				Post p = new Post();
				p.entity2model(item);
				list.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		
		return list;
	}
}