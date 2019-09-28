package com.springmvc.dao;

import com.springmvc.entities.AuthorEntity;
import com.springmvc.models.Author;
import java.util.List;
import javax.persistence.ParameterMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAOImpl implements DAOBase<Author>, AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author getById(int id) {
		Author author = new Author();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			AuthorEntity authorEntity = (AuthorEntity) session.get(AuthorEntity.class, id);
			
			author.entity2model(authorEntity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return author;
	}

	@Override
	public boolean save(Author entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Author entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Author entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFullName(int id) {
		String fullName = "";
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			ProcedureCall spQuery = session.createStoredProcedureCall("sp_Author_getFullName");
			spQuery.registerParameter("id", Integer.class, ParameterMode.IN);
			spQuery.setParameter("id", id);
			
			fullName = (String) spQuery.getResultList().get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fullName;
	}

}
