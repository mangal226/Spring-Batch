package com.soprasteria.academy.tpx1.springcloudtask.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Task Properties. 
 */
@ConfigurationProperties(prefix="tp1x")
public class TaskProperties {

	/**
	 * Task name.
	 */
	private String taskName = "<No Name>";

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}
