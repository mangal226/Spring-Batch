package com.soprasteria.academy.tp6;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TP6Lanceur {

	public static void main(String[] args) throws Exception {
		// ouverture du contexte
		AnnotationConfigApplicationContext contexte = new AnnotationConfigApplicationContext();
		contexte.getEnvironment().setActiveProfiles("monitor");
		contexte.register(AppConfig.class);
		contexte.refresh();

		// recuperation du lanceur
		JobLauncher jobLauncher = contexte.getBean(JobLauncher.class);

		// recuperation du job
		Job job = (Job)contexte.getBean("tp6JobID");

		// chargement des parametres
		JobParametersBuilder jobParamsBuilder = new JobParametersBuilder();
		for (String param : args) {
		    jobParamsBuilder.addString(param, param);
        }

		// demarrage du job
		jobLauncher.run(job, jobParamsBuilder.toJobParameters());

		// fermeture du contexte
		contexte.close();
	}
}
