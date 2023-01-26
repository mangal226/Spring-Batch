package com.soprasteria.academy.tpx1.springcloudtask.task;

import java.util.Objects;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class Tp1xTask implements ApplicationRunner {

	private String taskName;
	
	public Tp1xTask(final String taskName) {
		this.taskName = Objects.requireNonNull(taskName, "task name must be set");
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(args.containsOption("msg")) {
			String msg = args.getOptionValues("msg").toString();
			System.out.println("Task " + taskName + " message is : " + msg);
		} else {
			System.out.println("Task " + taskName + " has no message");
		};
	}
	
}
