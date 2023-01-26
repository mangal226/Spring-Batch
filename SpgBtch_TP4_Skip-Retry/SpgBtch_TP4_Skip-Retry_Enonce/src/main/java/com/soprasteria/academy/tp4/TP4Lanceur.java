package com.soprasteria.academy.tp4;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TP4Lanceur {

	// chemin du fichier de configuration spring
	private static final String NOM_FICHIER_CONTEXTE = "com/soprasteria/academy/tp4/context/tp4.job.context.xml";

	public static void main(String[] args) throws Exception {
		// ouverture du contexte
		ClassPathXmlApplicationContext contexte = new ClassPathXmlApplicationContext(NOM_FICHIER_CONTEXTE);

		// recuperation du lanceur
		JobLauncher jobLauncher = contexte.getBean(JobLauncher.class);

		// recuperation du job
		Job job = (Job)contexte.getBean("tp4JobID");

		// fermeture du contexte
		contexte.close();

		// chargement des parametres
		JobParameters jobParameters = new JobParameters();

		// demarrage du job
		jobLauncher.run(job, jobParameters);
	}
}