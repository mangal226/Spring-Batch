package com.soprasteria.academy.tp8.tasklet;

import java.text.MessageFormat;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TP8Tasklet implements Tasklet {
    
    private String msg;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(MessageFormat.format(msg,chunkContext.getStepContext().getStepExecution().getWriteCount()));
        contribution.incrementWriteCount(1);
        return RepeatStatus.continueIf(
            chunkContext.getStepContext().getStepExecution().getWriteCount() < 1000);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}