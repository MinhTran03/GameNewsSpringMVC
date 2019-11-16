package com.springmvc.util;

import java.util.List;

import com.springmvc.models.Role;
import com.springmvc.models.UserInfo;

public class CurrentLogin {
	public static boolean loggingIn = false;
	public static String userName = null;
	public static List<Role> roles = null;
	public static int id = -1;
	public static String fullName = null;
	public static String redirectStr = "/topic/game-home";
	public static String imagePath = null;
	public static String privateCode = null;
	
	public static UserInfo userWaitEmail = null;
	
	public static String Login() {
		if(loggingIn == false) {
			return "redirect:/login/";
		}
		return "";
	}
}
