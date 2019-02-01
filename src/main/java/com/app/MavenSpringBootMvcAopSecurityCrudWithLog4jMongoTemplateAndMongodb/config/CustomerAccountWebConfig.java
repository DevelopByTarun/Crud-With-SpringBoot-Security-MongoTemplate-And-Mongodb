package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.interceptors.LoggerInterceptor;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.interceptors.LoginInterceptor;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.interceptors.SessionTimerInterceptor;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.interceptors.UserInterceptor;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@PropertySource("classpath:log4j.properties")
@ComponentScan(basePackages = "com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb")
public class CustomerAccountWebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
		.addResourceLocations("/static/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    // mvc interceptors
		registry.addInterceptor(new LoginInterceptor());
	    registry.addInterceptor(new LoggerInterceptor());
	    registry.addInterceptor(new UserInterceptor());
	    registry.addInterceptor(new SessionTimerInterceptor());
	}
}
