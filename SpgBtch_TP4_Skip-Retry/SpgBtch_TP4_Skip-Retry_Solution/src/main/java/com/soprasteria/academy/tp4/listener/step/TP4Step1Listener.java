package com.soprasteria.academy.tp4.listener.step;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;

import com.soprasteria.academy.tp4.exception.TP4FiltreException;
import com.soprasteria.academy.tp4.model.TP4Livre;

public class TP4Step1Listener implements StepExecutionListener, ItemReadListener<TP4Livre>,
		ItemProcessListener<TP4Livre, TP4Livre>, ItemWriteListener<TP4Livre>, ChunkListener {

	private static Logger log = LoggerFactory.getLogger("StepListener");
	private SimpleDateFormat sdfChrono = new SimpleDateFormat("HH:mm:ss");

	private StepExecution execution;
	
	private int chunknumber;

	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.execution = stepExecution;
		String heureDebut = sdfChrono.format(stepExecution.getStartTime());
		log.info("Debut du step '{}' à {}.", stepExecution.getStepName(), heureDebut);
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		int nbLu = stepExecution.getReadCount();
		log.info(". {} elements lus.", nbLu);
		int nbFiltre = stepExecution.getFilterCount();
		log.info(". {} elements filtrés.", nbFiltre);
		int nbSkip = stepExecution.getSkipCount();
		log.info(". {} elements en erreur et ignorés.",nbSkip);
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
	public void afterRead(TP4Livre item) {
		log.debug("afterRead - {}", item.getIsbn());
	}

	@Override
	public void onReadError(Exception ex) {
		execution.addFailureException(ex);
		if (TP4FiltreException.class.isInstance(ex)) {
			log.debug("onReadError - {}", TP4FiltreException.class.cast(ex).getIsbn());
		}

	}

	@Override
	public void beforeProcess(TP4Livre item) {
		log.debug("beforeProcess - {}", item.getIsbn());
	}

	@Override
	public void afterProcess(TP4Livre item, TP4Livre result) {
	}

	@Override
	public void onProcessError(TP4Livre item, Exception e) {
		execution.addFailureException(e);
		log.debug("onProcessError - {}", item.getIsbn());
	}

	@Override
	public void beforeWrite(List<? extends TP4Livre> items) {
		log.debug("beforeWrite {} items", items.size());
	}

	@Override
	public void afterWrite(List<? extends TP4Livre> items) {
		log.debug("afterWrite {} items", items.size());
	}

	@Override
	public void onWriteError(Exception exception, List<? extends TP4Livre> items) {
		execution.addFailureException(exception);
		if (TP4FiltreException.class.isInstance(exception)) {
			log.debug("onWriteError - {}", TP4FiltreException.class.cast(exception).getIsbn());
		}
	}

	@Override
	public void beforeChunk(ChunkContext context) {
		log.debug("beforeChunk ------------------------- {} ", (++chunknumber));
	}

	@Override
	public void afterChunk(ChunkContext context) {
		log.debug("afterChunk -------------------------- {} ", chunknumber);
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		log.debug("afterChunkError --------------------- {} ", chunknumber);
	}
}
