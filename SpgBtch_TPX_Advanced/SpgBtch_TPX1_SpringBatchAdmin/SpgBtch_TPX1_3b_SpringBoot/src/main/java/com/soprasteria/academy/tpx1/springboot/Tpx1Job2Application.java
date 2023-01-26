package com.soprasteria.academy.tpx1.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Import;

import com.soprasteria.academy.tpx1.job.config.MainConfiguration;

@SpringBootApplication
@EnableTask
@Import({MainConfiguration.class})
public class Tpx1Job2Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Tpx1Job2Application.class, args);
	}

}
