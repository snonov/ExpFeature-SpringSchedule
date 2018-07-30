package com.snonov.explore.springscheduler.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.snonov.explore.springscheduler.sometasks.ABusinessService;

@Configuration
@Import({ FixScheduledJavaConfig.class, DynamicScheduledJavaConfig.class })
public class SprSchedulMainJavaConfig {

	@Bean
	public ABusinessService aBusinessService() {
		
		ABusinessService aBusinessService = new ABusinessService();
		
		return aBusinessService;
	}
	
	
}
