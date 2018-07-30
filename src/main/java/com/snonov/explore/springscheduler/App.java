package com.snonov.explore.springscheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.snonov.explore.springscheduler.spring.SprSchedulMainJavaConfig;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
@EnableMBeanExport
@Import(SprSchedulMainJavaConfig.class)
public class App {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {

		LOGGER.info("Start Main");
		SpringApplication.run(App.class);
		//to process with out SpringBoot
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(SprSchedulMainJavaConfig.class);
		LOGGER.info("End Main");
	}
	
}
