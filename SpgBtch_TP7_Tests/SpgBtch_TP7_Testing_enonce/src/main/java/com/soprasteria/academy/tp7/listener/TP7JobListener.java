package com.soprasteria.academy.tp7.listener;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class TP7JobListener implements JobExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger("Job Listener");

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOGGER.info("Demarrage du batch TP7");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        LOGGER.info("Fin du batch TP7");
        jobExecution.setEndTime(new Date(0L));
    }
}
