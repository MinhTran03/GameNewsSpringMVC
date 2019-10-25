package com.springmvc.dao;

import java.util.List;

import com.springmvc.models.Post;
import com.springmvc.models.Role;
import com.springmvc.models.UserInfo;

public interface UserDAO extends DAOBase<UserInfo> {
	
	public String getFullName(int id);
	
	public List<Role> checkLogin(String email, String password);
	
	public int getIdByEmail(String email);
	
//	public boolean isExist(String email);
	
	public List<Post> getInRange(int skip, int take, int userId);
	
	public List<UserInfo> getInRange(int skip, int take, String roleName);
	
	public int countUserOfRole(String role);
	
	public boolean isContainEmail(String email);
}
