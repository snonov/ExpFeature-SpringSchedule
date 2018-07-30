package com.snonov.explore.springscheduler.scheduleservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public class ScheduleTaskHolder {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTaskHolder.class);
	
	List<ScheduledFuture<?>> allDynamicScheduledFuture = new ArrayList<>();
	
	public void addScheduledFuture(ScheduledFuture<?> toAdd) {
		LOGGER.info("Add a ScheduledFuture");
		allDynamicScheduledFuture.add(toAdd);
	}
	
	@ManagedOperation
	public void pauseAll() {
		LOGGER.info("pauseAll ScheduledFuture");
		for (ScheduledFuture<?> scheduledFuture : allDynamicScheduledFuture) {
			boolean mayInterruptIfRunning =true;
			scheduledFuture.cancel(mayInterruptIfRunning );
		}	
	}
	
	
	
}
