package com.soprasteria.academy.tpx1.bdd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.soprasteria.academy.tpx1.bdd.config.MainConfiguration;

public class MainSpringContext {

	public static void runWithMainConfiguration(final String... profiles) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(profiles);
		context.register(MainConfiguration.class);
		context.refresh();
		context.close();
	}

}
