package com.snonov.explore.springscheduler.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.snonov.explore.springscheduler.sometasks.ABusinessService;

@Configuration
public class FixScheduledJavaConfig {

	@Autowired
	private ABusinessService aBusinessService;
	
	
	@Bean
	/**
	 *Let override default default scheduling thread pool that have only 1 thread
	 *Other way would be to add @Configuration implements SchedulingConfigurer 
	 *and override public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar)
	 */
	public  ThreadPoolTaskScheduler  taskScheduler(){
	    ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
	    taskScheduler.setPoolSize(2);
	    taskScheduler.setThreadNamePrefix("ScheduledTask-");
	    return  taskScheduler;
	}
	
	@Scheduled(cron="*/10 * * * * *")
	/**
	 * Check CRON syntax
	 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
	 */
	public void myScheduleJob() {
		aBusinessService.displayTime(1000, "myScheduleJob");
	}
	
	@Scheduled(cron="*/10 * * * * *")
	public void mySecondScheduleJob() {
		aBusinessService.displayTime(1000, "mySecondScheduleJob");
	}
	
}
