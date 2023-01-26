package com.soprasteria.academy.tpx1.springcloudtask.listener;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

public class TaskListener implements TaskExecutionListener {

	@Override
	public void onTaskStartup(TaskExecution taskExecution) {
		System.out.println("Task " + taskExecution.getTaskName() + " startup at " + taskExecution.getStartTime());
	}

	@Override
	public void onTaskEnd(TaskExecution taskExecution) {
		System.out.println("Task " + taskExecution.getTaskName() + " end at " + taskExecution.getEndTime());
	}

	@Override
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		System.out.println("Task " + taskExecution.getTaskName() + " failed with exit " + taskExecution.getExitCode());
	}

}
