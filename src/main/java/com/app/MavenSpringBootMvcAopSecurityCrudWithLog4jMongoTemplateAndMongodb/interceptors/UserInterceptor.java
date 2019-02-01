package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.interceptors;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.SmartView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = Logger.getLogger(UserInterceptor.class);

    /**
     * Executed before actual handler is executed
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
    	logger.debug("****Going To Enter PreHandle Method Of UserInterceptor****");
    	logger.debug("");
    	logger.debug("");
    	System.out.println("");
    	System.out.println("This Is PreHandle Method Of UserInterceptor Is Called");
    	if (isUserLogged()) {
            addToModelUserDetails(request.getSession());
        }
        return true;
    }

    /**
     * Executed before after handler is executed. If view is a redirect view, we don't need to execute postHandle
     **/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model) throws Exception {
    	logger.debug("****Going To Enter PostHandle Method Of UserInterceptor****");
    	logger.debug("");
    	logger.debug("");
    	System.out.println("");
    	System.out.println("This Is PostHandle Method Of UserInterceptor Is Called");
    	if (model != null && !isRedirectView(model)) {
            if (isUserLogged()) {
                addToModelUserDetails(model);
            }
        }
    }

    /**
     * Used before model is generated, based on session
     */
    private void addToModelUserDetails(HttpSession session) {
    	System.out.println("");
        logger.debug("================= addToModelUserDetails ============================");
        System.out.println("================= addToModelUserDetails ============================");
        String loggedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        session.setAttribute("username", loggedUsername);
        logger.debug("user(" + loggedUsername + ") session : " + session);
        logger.debug("================= addToModelUserDetails ============================");
        logger.debug("");
        logger.debug("");
        System.out.println("user(" + loggedUsername + ") session : " + session);
        System.out.println("================= addToModelUserDetails ============================");
        System.out.println("");
    }

    /**
     * Used when model is available
     */
    private void addToModelUserDetails(ModelAndView model) {
    	System.out.println("");
        logger.debug("================= addToModelUserDetails ============================");
        System.out.println("================= addToModelUserDetails ============================");
        String loggedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addObject("loggedUsername", loggedUsername);
        logger.debug("session : " + model.getModel());
        logger.debug("================= addToModelUserDetails ============================");
        logger.debug("");
        logger.debug("");
        System.out.println("session : " + model.getModel());
        System.out.println("================= addToModelUserDetails ============================");
        System.out.println("");
    }

    public static boolean isRedirectView(ModelAndView mv) {

        String viewName = mv.getViewName();
        if (viewName.startsWith("redirect:/")) {
            return true;
        }

        View view = mv.getView();
        return (view != null && view instanceof SmartView && ((SmartView) view).isRedirectView());
    }

    public static boolean isUserLogged() {
        try {
            return !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser");
        } catch (Exception e) {
            return false;
        }
    }
}
