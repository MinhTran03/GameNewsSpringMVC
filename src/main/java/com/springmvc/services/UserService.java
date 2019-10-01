package com.springmvc.services;

import java.util.List;
import com.springmvc.models.Role;
import com.springmvc.models.UserInfo;

public interface UserService extends ServiceBase<UserInfo> {
	
	public String getFullName(int id);
	
	public List<Role> checkLogin(String email, String password);
}
