package com.soprasteria.academy.tpx1.job.config;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soprasteria.academy.tpx1.job.tasklet.TPX1Tasklet;

@Configuration
public class TaskletConfiguration {
	
	@Bean
	@StepScope
	public Tasklet tasklet(@Value("#{jobParameters[msg]}") String msg) {
		TPX1Tasklet tasklet = new TPX1Tasklet();
		tasklet.setMsg(msg);
		return tasklet;
	}
}
