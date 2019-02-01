package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = Logger.getLogger(LoginInterceptor.class);
	
	/**
     * Executed before actual handler is executed
     **/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("****Going To Enter PreHandle Method Of LoginInterceptor****");
		System.out.println("This Is PreHandle Method Of LoginInterceptor Is Called");
		System.out.println("Request Url Is :: "+request.getRequestURL());
		System.out.println("");
		logger.debug("Request Url Is :: "+request.getRequestURL());
		logger.debug("");
		logger.debug("");
		return super.preHandle(request, response, handler);
	}
	
	/**
     * Executed before after handler is executed
     **/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
		logger.debug("****Going To Enter PostHandle Method Of LoginInterceptor****");
		System.out.println("This Is PostHandle Method Of LoginInterceptor Is Called");
		System.out.println("Request Uri Is :: "+request.getRequestURI());
		logger.debug("Request Uri Is :: "+request.getRequestURI());
		logger.debug("");
		logger.debug("");
		super.postHandle(request, response, handler, model);
		System.out.println("");
	}
	
	/**
     * Executed after complete request is finished
     **/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.debug("****Going To Enter AfterCompletion Method Of LoginInterceptor****");
		logger.debug("");
		logger.debug("");
		System.out.println("This Is AfterCompletion Method Of LoginInterceptor Is Called");
		super.afterCompletion(request, response, handler, ex);
		System.out.println("");
	}
}
