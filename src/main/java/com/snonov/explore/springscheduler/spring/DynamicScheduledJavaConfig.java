package com.snonov.explore.springscheduler.spring;

import java.util.concurrent.ScheduledFuture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import com.snonov.explore.springscheduler.scheduleservice.ScheduleTaskHolder;
import com.snonov.explore.springscheduler.sometasks.ABusinessService;
import com.snonov.explore.springscheduler.sometasks.dynamicTask.RunnableTask;

@Configuration
public class DynamicScheduledJavaConfig {

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(2);
		threadPoolTaskScheduler.setThreadNamePrefix("ScheduledTaskDynamic-");
		
		return threadPoolTaskScheduler;
	}

	@Bean
	public ScheduleTaskHolder scheduleTaskHolder() {
		
		ScheduleTaskHolder scheduleTaskHolder = new ScheduleTaskHolder();
		return scheduleTaskHolder;
	}
	
	@Bean
	public Void createDynamicTask(ABusinessService aBusinessService, ThreadPoolTaskScheduler threadPoolTaskScheduler, ScheduleTaskHolder scheduleTaskHolder) {
		
		CronTrigger cronTrigger = new CronTrigger("*/10 * * * * ?");
		ScheduledFuture<?> schedule1 = threadPoolTaskScheduler.schedule(new RunnableTask(aBusinessService, "First"), cronTrigger);
		ScheduledFuture<?> schedule2 = threadPoolTaskScheduler.schedule(new RunnableTask(aBusinessService, "Second"), cronTrigger);
		
		scheduleTaskHolder.addScheduledFuture(schedule1);
		scheduleTaskHolder.addScheduledFuture(schedule2);
		
		return null;		
	}
	
}
