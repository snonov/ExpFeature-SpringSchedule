package com.snonov.explore.springscheduler.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.snonov.explore.springscheduler.sometasks.ABusinessService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SprSchedulMainJavaConfig.class })
class SprSchedulMainJavaConfigTest {

	@Autowired
	ABusinessService aBusinessService;
	
	@Test
	void test() {
		
		assertTrue(aBusinessService != null);
		long durationMs = 2 * 1000;
		aBusinessService.displayTime(durationMs, "Test");
	}

}
