package com.snonov.explore.springscheduler.sometasks.dynamicTask;

import com.snonov.explore.springscheduler.sometasks.ABusinessService;

public class RunnableTask implements Runnable {

	private ABusinessService aBusinessService;
	private String message;
    
    public RunnableTask(ABusinessService aBusinessService, String message){
        this.aBusinessService = aBusinessService;
        this.message = message;
    }
	
	@Override
	public void run() {
		aBusinessService.displayTime(1000, "myDynamicScheduleJob run [" + message + "]");
	}

}
