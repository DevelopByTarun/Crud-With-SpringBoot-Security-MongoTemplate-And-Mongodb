package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = "com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb")
public class CustomerAccountSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// Authentication : set user/password details and mention the role through manually
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationBuilder) {
		try {
			authenticationBuilder.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
			.withUser("tarun").password("user").roles("USER")
			.and()
			.withUser("amit").password("admin").roles("USER", "ADMIN");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Authorization : mention which role can access which URL
	@Override
	protected void configure(HttpSecurity http) {
		try {
			 http.csrf().disable()
			 .authorizeRequests().antMatchers("/login").permitAll()
             .antMatchers("/", "/*customer*/**").access("hasRole('USER')").and()
             .formLogin()
             .and()
             .logout();
			 http.exceptionHandling().accessDeniedPage("/accessdenied-customer");			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
