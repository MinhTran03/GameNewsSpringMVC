package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInfoInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
//		UserInfo currentUser = (UserInfo)request.getAttribute("current_user");
//		modelAndView.addObject("current_user", currentUser);
//		modelAndView.addObject("loggingIn", CurrentLogin.loggingIn);
//		if(CurrentLogin.loggingIn)
//			modelAndView.addObject("role", CurrentLogin.roles.get(0).getRoleName());
//		modelAndView.addObject("avataUser", CurrentLogin.imagePath);
//		modelAndView.addObject("nameUser", CurrentLogin.fullName);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
