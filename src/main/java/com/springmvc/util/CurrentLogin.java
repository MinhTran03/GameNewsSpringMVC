package com.springmvc.util;

import java.util.List;

import com.springmvc.models.Role;

public class CurrentLogin {
	public static boolean loggingIn = false;
	public static String userName = null;
	public static List<Role> roles = null;
	public static int id = -1;
	public static String redirectStr = "";
	
	public static String isLogin() {
		if(loggingIn == false) {
			return "redirect:/login/";
		}
		return "";
	}
}
