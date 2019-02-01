package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	private Logger logger = Logger.getLogger(WelcomeController.class);
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage() {
		logger.debug("Going To Enter On Welcome Page");
		logger.debug("");
		logger.debug("");
		return "index";
	}
}
