package com.springmvc.services;

import java.util.List;

import com.springmvc.models.Post;
import com.springmvc.models.Role;
import com.springmvc.models.UserInfo;

public interface UserService extends ServiceBase<UserInfo> {
	
	public String getFullName(int id);
	
	public List<Role> checkLogin(String email, String password);
	
	public int getIdByEmail(String email);
	
	public List<Post> getInRange(int skip, int take, int userId);
	
	public List<UserInfo> getInRange(int skip, int take, String roleName);
	
	public int countUserOfRole(String role);
	
	public boolean isContainEmail(String email);
}
