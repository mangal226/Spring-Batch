package com.soprasteria.academy.tp7.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class TP7StepListener implements StepExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger("Step Listener");

    @Override
    public void beforeStep(StepExecution stepExecution) {
        LOGGER.info("Debut du step");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}
