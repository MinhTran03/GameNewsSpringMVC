package com.springmvc.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.dao.UserDAO;
import com.springmvc.models.Role;
import com.springmvc.models.UserInfo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<UserInfo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getById(int id) {
		return userDAO.getById(id);
	}

	@Override
	public int save(UserInfo entity) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean update(UserInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFullName(int id) {
		// TODO Auto-generated method stub
		return userDAO.getFullName(id);
	}

	@Override
	public List<Role> checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		return userDAO.checkLogin(email, password);
	}

	@Override
	public int getIdByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.getIdByEmail(email);
	}

}
