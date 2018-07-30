package com.snonov.explore.springscheduler.sometasks;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ABusinessService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ABusinessService.class);

	public void displayTime(long msToSleepDuring, String taskParentName) {

		LOGGER.info("displayTime [{}] with duration [{}] ms", taskParentName, msToSleepDuring);
		Instant start = Instant.now();

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
		String formatDateTime = now.format(formatter);

		try {
			Thread.sleep(msToSleepDuring);
		} catch (InterruptedException e) {
			LOGGER.error("InterruptedException ["+taskParentName+"] ", e);
		}
		
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		LOGGER.info("[{}] formatDateTime [{}], effective task duration [{}] ms", taskParentName, formatDateTime, timeElapsed);
		
	}

}
