package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionTimerInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = Logger.getLogger(SessionTimerInterceptor.class);

    private static final long MAX_INACTIVE_SESSION_TIME = 5 * 10000;

    @Autowired
    private HttpSession session;

    /**
     * Executed before actual handler is executed
     **/
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
    	logger.debug("****Going To Enter PreHandle Method Of SessionTimerInterceptor****");
    	System.out.println("");
    	System.out.println("This Is PreHandle Method Of SessionTimerInterceptor Is Called");
        logger.debug("Pre handle method - check handling start time");
        long startTime = System.currentTimeMillis();
        request.setAttribute("executionTime", startTime);
        if (UserInterceptor.isUserLogged()) {
            session = request.getSession();
            logger.debug("Time since last request in this session: {} ms :-"+(System.currentTimeMillis() - request.getSession().getLastAccessedTime()));
            System.out.println("Time since last request in this session: {} ms :-"+(System.currentTimeMillis() - request.getSession().getLastAccessedTime()));
            System.out.println("Session Is :: "+(System.currentTimeMillis() - session.getLastAccessedTime() > MAX_INACTIVE_SESSION_TIME));
            System.out.println("");
            logger.debug("Session Is :: "+(System.currentTimeMillis() - session.getLastAccessedTime() > MAX_INACTIVE_SESSION_TIME));
            logger.debug("");
            logger.debug("");
        }
        return true;
    }

    /**
     * Executed before after handler is executed
     **/
    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView model) throws Exception {
    	logger.debug("****Going To Enter PostHandle Method Of SessionTimerInterceptor****");
    	System.out.println("This Is PostHandle Method Of SessionTimerInterceptor Is Called");
    	logger.debug("Post handle method - check execution time of handling");
        long startTime = (Long) request.getAttribute("executionTime");
        logger.debug("Execution time for handling the request was: {} ms :-"+(System.currentTimeMillis() - startTime));
        logger.debug("");
        logger.debug("");
        System.out.println("Execution time for handling the request was: {} ms :-"+(System.currentTimeMillis() - startTime));
        System.out.println("");
    }
}
