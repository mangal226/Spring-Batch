package com.soprasteria.academy.tp4.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class TP4JobListener implements JobExecutionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger("Job Listener");
	private SimpleDateFormat sdfDate = new SimpleDateFormat("dd MMM yyyy");
	private SimpleDateFormat sdfChrono = new SimpleDateFormat("HH:mm:ss");
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		LOGGER.info("Demarrage de l'intégration des livres!");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		LOGGER.info("Fin de l'intégration des livres.");
		Date startTime = jobExecution.getStartTime();
		String dateDebut = sdfDate.format(startTime);
		String heureDebut = sdfChrono.format(startTime);
		LOGGER.info(". Le batch a démarré le {} à {}.", dateDebut, heureDebut);
		Date endTime = jobExecution.getEndTime();
		String dateFin = sdfDate.format(endTime);
		String heureFin= sdfChrono.format(endTime);
		LOGGER.info(". Le batch a terminé le {} à {}.", dateFin, heureFin);

		List<Throwable> failureExceptions = jobExecution.getAllFailureExceptions();
		if (CollectionUtils.isNotEmpty(failureExceptions)) {
			LOGGER.warn("{} erreurs survenue durant l'execution.", failureExceptions.size());
		} else {
			LOGGER.info("Pas d'erreur durant le batch.");
		}
	}

}
