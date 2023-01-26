package com.soprasteria.academy.tpx1.springboot;

import org.springframework.batch.core.BatchStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobExecutionEvent;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;

import com.soprasteria.academy.tpx1.job.config.MainConfiguration;

@SpringBootApplication
@EnableTask
@Import({MainConfiguration.class})
public class Tpx1JobApplication {

	public static void main(String[] args) throws Exception {
		System.exit(SpringApplication.exit(SpringApplication.run(Tpx1JobApplication.class, args)));
	}
	
	
	/**
	 * Part due to spring-cloud-task version (prior to 2.0.0)
	 */
	@Autowired
	private ApplicationContext context;
	
	@EventListener
	public void listener(JobExecutionEvent jobExecutionEvent) {
		BatchStatus status = jobExecutionEvent.getJobExecution().getStatus();
		if (status != BatchStatus.COMPLETED) {
			ExitCodeEvent event = new ExitCodeEvent(context, status.ordinal());
			context.publishEvent(event);
		}
	}
	
}
