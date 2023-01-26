package com.soprasteria.academy.tpx1.springcloudtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Import;

import com.soprasteria.academy.tpx1.springcloudtask.config.MainConfiguration;

@SpringBootApplication
@Import({MainConfiguration.class})
public class Tpx1TaskApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Tpx1TaskApplication.class, args);
	}

}
