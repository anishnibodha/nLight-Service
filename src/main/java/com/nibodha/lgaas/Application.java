package com.nibodha.lgaas;

import org.apache.log4j.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan
@PropertySource("classpath:application.properties")
public class Application extends WebMvcConfigurerAdapter {
	private static final Category LOGGER = Category
			.getInstance(Application.class);
	public static void main(String[] args) throws Exception {
		SpringApplication.run(
				Application.class, args);
		LOGGER.info("NLight Service Started !!! ");

	}
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	       
	    }

	
	
	
}
