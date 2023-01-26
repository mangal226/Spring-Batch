package com.soprasteria.academy.tp5;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TP5Lanceur {

	// chemin du fichier de configuration spring
	private static final String NOM_FICHIER_CONTEXTE = "com/soprasteria/academy/tp5/context/tp5.job.context.xml";

	public static void main(String[] args) throws Exception {
		// ouverture du contexte
		ClassPathXmlApplicationContext contexte = new ClassPathXmlApplicationContext(NOM_FICHIER_CONTEXTE);

		// recuperation du lanceur
		JobLauncher jobLauncher = contexte.getBean(JobLauncher.class);

		// recuperation du job
		Job job = (Job)contexte.getBean("tp5JobID");

		// fermeture du contexte
		contexte.close();

		// chargement des parametres
		JobParametersBuilder jobParamsBuilder = new JobParametersBuilder();
		for (String param : args) {
		    jobParamsBuilder.addString(param, param);
        }

		// demarrage du job
		jobLauncher.run(job, jobParamsBuilder.toJobParameters());
	}
}