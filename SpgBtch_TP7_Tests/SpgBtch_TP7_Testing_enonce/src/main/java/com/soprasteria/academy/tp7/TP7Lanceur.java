package com.soprasteria.academy.tp7;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TP7Lanceur {

    // chemin du fichier de configuration spring
    private static final String NOM_FICHIER_CONTEXTE = "com/soprasteria/academy/tp7/context/tp7.job.context.xml";

    public static void main(String[] args) throws Exception {
        // ouverture du contexte
        ClassPathXmlApplicationContext contexte = new ClassPathXmlApplicationContext(NOM_FICHIER_CONTEXTE);

        // recuperation du lanceur
        JobLauncher jobLauncher = contexte.getBean(JobLauncher.class);

        // recuperation du job
        Job job = (Job) contexte.getBean("tp7JobID");

        // fermeture du contexte
        contexte.close();

        // chargement des parametres
        JobParametersBuilder jobParamsBuilder = new JobParametersBuilder();
        String[] keyvalue;
        for (String param : args) {
            keyvalue = param.split("=");
            jobParamsBuilder.addString(keyvalue[0], (keyvalue.length > 1) ? keyvalue[1] : null);
        }
        JobParameters jobParameters = jobParamsBuilder.toJobParameters();

        // demarrage du job
        jobLauncher.run(job, jobParameters);
    }
}