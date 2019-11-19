package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SaveInfoInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		if(!request.getRequestURL().toString().contentEquals("/GameNews/login") && !request.getRequestURL().toString().contentEquals("/GameNews/logout/")) {
//			System.out.println("==================================================" + request.getRequestURL().toString());
//			System.out.println("==================================================" + request.getRequestURL().toString());
//			CurrentLogin.redirectStr = request.getRequestURL().toString();
//		}
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
