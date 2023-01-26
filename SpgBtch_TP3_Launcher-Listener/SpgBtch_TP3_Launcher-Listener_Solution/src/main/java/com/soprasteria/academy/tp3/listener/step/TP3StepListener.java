package com.soprasteria.academy.tp3.listener.step;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import com.soprasteria.academy.tp3.model.TP3Livre;

public class TP3StepListener implements StepExecutionListener, ItemReadListener<TP3Livre>,
		ItemProcessListener<TP3Livre, TP3Livre>, ItemWriteListener<TP3Livre> {

	private static Logger log = LoggerFactory.getLogger("StepListener");
	private SimpleDateFormat sdfChrono = new SimpleDateFormat("HH:mm:ss");

	@Override
	public void beforeStep(StepExecution stepExecution) {
		String heureDebut = sdfChrono.format(stepExecution.getStartTime());
		log.info("Debut du step '{}' à {}.", stepExecution.getStepName(), heureDebut);
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		int nbLu = stepExecution.getReadCount();
		log.info(". {} elements lus.", nbLu);
		int nbFiltre = stepExecution.getFilterCount();
		log.info(". {} elements filtrés.", nbFiltre);
		int nbEcrit = stepExecution.getWriteCount();
		log.info(". {} elements ecrits.", nbEcrit);
		double tauxDeReussite = ((double)nbEcrit / (double)nbLu) * 100;
		log.info("= {}% integrés.",tauxDeReussite);
		if (tauxDeReussite >= 50) {
			return ExitStatus.COMPLETED;
		} else {
			return ExitStatus.FAILED;
		}
	}

	@Override
	public void beforeRead() {
	}

	@Override
	public void afterRead(TP3Livre item) {
	}

	@Override
	public void onReadError(Exception ex) {
	}

	@Override
	public void beforeProcess(TP3Livre item) {
	}

	@Override
	public void afterProcess(TP3Livre item, TP3Livre result) {
	}

	@Override
	public void onProcessError(TP3Livre item, Exception e) {
	}

	@Override
	public void beforeWrite(List<? extends TP3Livre> items) {
	}

	@Override
	public void afterWrite(List<? extends TP3Livre> items) {
	}

	@Override
	public void onWriteError(Exception exception, List<? extends TP3Livre> items) {
	}
}