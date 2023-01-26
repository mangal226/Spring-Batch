package com.soprasteria.academy.tpx1.job.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TPX1Tasklet implements Tasklet {

	private String msg;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("Tasklet message is : " + msg);
		return RepeatStatus.FINISHED;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
