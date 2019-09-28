package com.springmvc.services;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.AuthorDAO;
import com.springmvc.dao.DAOBase;
import com.springmvc.models.Author;

@Service
@Transactional
public class AuthorServiceImpl implements ServiceBase<Author>, AuthorService {

	@Autowired
	DAOBase<Author> authorDAOBase;
	
	@Autowired
	AuthorDAO authorDAO;
	
	@Override
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author getById(int id) {
		return authorDAOBase.getById(id);
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
		// TODO Auto-generated method stub
		return authorDAO.getFullName(id);
	}

}
