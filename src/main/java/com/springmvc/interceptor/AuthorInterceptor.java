package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.models.UserInfo;

public class AuthorInterceptor implements HandlerInterceptor {

	@Autowired
	HttpSession httpSession;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		UserInfo currentUser = (UserInfo)httpSession.getAttribute("current_user");
		
		if(!currentUser.getRoleName().contentEquals("AUTHOR")) {
			
			String path = request.getContextPath();
			response.sendRedirect(path + "/not-have-permistion");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
