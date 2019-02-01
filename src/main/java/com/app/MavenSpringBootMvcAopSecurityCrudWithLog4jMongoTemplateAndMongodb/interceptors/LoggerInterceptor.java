package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.interceptors;

import com.google.common.base.Strings;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = Logger.getLogger(LoggerInterceptor.class);

    /**
     * Executed before actual handler is executed
     **/
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
    	logger.debug("****Going To Enter PreHandle Method Of LoggerInterceptor****");
    	System.out.println("");
    	System.out.println("This Is PreHandle Method Of LoggerInterceptor Is Called");
    	logger.debug("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI() + getParameters(request));
    	logger.debug("");
    	logger.debug("");
    	System.out.println("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI() + getParameters(request));
    	System.out.println("");
        return true;
    }

    /**
     * Executed before after handler is executed
     **/
    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {
    	logger.debug("****Going To Enter PostHandle Method Of LoggerInterceptor****");
    	System.out.println("");
    	System.out.println("This Is PostHandle Method Of LoggerInterceptor Is Called");
    	logger.debug("[postHandle][" + request + "]");
    	logger.debug("");
    	logger.debug("");
    	System.out.println("[postHandle][" + request + "]");
    	System.out.println("");
    }

    /**
     * Executed after complete request is finished
     **/
    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {
    	logger.debug("****Going To Enter AfterCompletion Method Of LoggerInterceptor****");
    	System.out.println("This Is AfterCompletion Method Of LoggerInterceptor Is Called");
    	if (ex != null)
            ex.printStackTrace();
    	logger.debug("[afterCompletion][" + request + "][exception: " + ex + "]");
    	logger.debug("");
    	logger.debug("");
    	System.out.println("[afterCompletion][" + request + "][exception: " + ex + "]");
    	System.out.println("");
    }

    private String getParameters(final HttpServletRequest request) {
        final StringBuffer posted = new StringBuffer();
        final Enumeration<?> e = request.getParameterNames();
        if (e != null)
            posted.append("?");
        while (e != null && e.hasMoreElements()) {
            if (posted.length() > 1)
                posted.append("&");
            final String curr = (String) e.nextElement();
            posted.append(curr).append("=");
            if (curr.contains("password") || curr.contains("answer") || curr.contains("pwd")) {
                posted.append("*****");
            } else {
                posted.append(request.getParameter(curr));
            }
        }

        final String ip = request.getHeader("X-FORWARDED-FOR");
        final String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
        if (!Strings.isNullOrEmpty(ipAddr))
            posted.append("&_psip=" + ipAddr);
        return posted.toString();
    }

    private String getRemoteAddr(final HttpServletRequest request) {
        final String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
        	logger.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
        	logger.debug("");
        	logger.debug("");
        	System.out.println("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
        	System.out.println("");
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }
}
