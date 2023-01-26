package com.soprasteria.academy.tp1;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TP1Lanceur {

	// chemin du fichier de configuration spring
	private static final String NOM_FICHIER_CONTEXTE = "com/soprasteria/academy/tp1/context/tp1.job.context.xml";

	public static void main(String[] args) throws JobExecutionException {
		// ouverture du contexte
		ClassPathXmlApplicationContext contexte = new ClassPathXmlApplicationContext(NOM_FICHIER_CONTEXTE);

		// recuperation du lanceur
		JobLauncher jobLauncher = contexte.getBean(JobLauncher.class);

		// recuperation du job
		Job job = contexte.getBean(Job.class);

		// fermeture du contexte
		contexte.close();

		// chargement des parametres
		JobParameters jobParameters = new JobParameters();

		// demarrage du job
		jobLauncher.run(job, jobParameters);
	}
}