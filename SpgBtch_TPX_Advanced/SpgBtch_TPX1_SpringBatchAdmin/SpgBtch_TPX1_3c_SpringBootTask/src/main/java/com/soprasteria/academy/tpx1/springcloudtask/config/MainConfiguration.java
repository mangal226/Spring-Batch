package com.soprasteria.academy.tpx1.springcloudtask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.soprasteria.academy.tpx1.bdd.config.DatasourceConfiguration;
import com.soprasteria.academy.tpx1.springcloudtask.listener.TaskListener;
import com.soprasteria.academy.tpx1.springcloudtask.task.Tp1xTask;

@Configuration
@EnableTask
@EnableConfigurationProperties({TaskProperties.class})
@Import({DatasourceConfiguration.class})
@PropertySource(
		value={"classpath:/com/soprasteria/academy/tpx1/bdd/tpx1.bdd.properties"},
		ignoreResourceNotFound=false
)
public class MainConfiguration {

	@Autowired
	private TaskProperties properties;
	
	@Bean
	public Tp1xTask task() {
		String taskName = properties.getTaskName();
		return new Tp1xTask(taskName);
	}
	
	@Bean
	public TaskExecutionListener taskListener() {
		return new TaskListener();
	}
}
