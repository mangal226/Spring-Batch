package com.soprasteria.academy.tp9.listener;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class TP9Listener implements StepExecutionListener, ChunkListener {

    private static final Logger LOGGER = Logger.getLogger("StepListener");

    @Override
    public void beforeStep(StepExecution stepExecution) {
        LOGGER.info("=> START: " + stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        LOGGER.info("=> STOP : " + stepExecution.getStepName());
        return ExitStatus.COMPLETED;
    }

    @Override
    public void beforeChunk(ChunkContext context) {
        LOGGER.info("---> START: " + context.getStepContext().getStepName()+" , "+context.getStepContext().getStepExecutionContext().get("fileName"));
    }

    @Override
    public void afterChunk(ChunkContext context) {
        LOGGER.info("---> STOP : " + context.getStepContext().getStepName()+" , "+context.getStepContext().getStepExecutionContext().get("fileName"));
    }

    @Override
    public void afterChunkError(ChunkContext context) {
    }
}