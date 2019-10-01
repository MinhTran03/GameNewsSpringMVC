package com.springmvc.util;

import java.util.List;

import com.springmvc.models.Role;

public class CurrentLogin {
	public static int id = -1;
	public static String userName = null;
	public static List<Role> roles = null;
	
	public static String isLogin() {
		if(id == -1) {
			return "redirect:/login/";
		}
		return "";
	}
}
