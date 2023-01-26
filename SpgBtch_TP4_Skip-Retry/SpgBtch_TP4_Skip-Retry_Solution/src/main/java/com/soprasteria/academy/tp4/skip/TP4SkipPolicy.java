package com.soprasteria.academy.tp4.skip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.step.skip.SkipPolicy;

import com.soprasteria.academy.tp4.exception.TP4FiltreException;

public class TP4SkipPolicy implements SkipPolicy{

	private Logger log = LoggerFactory.getLogger("Skip Policy");
	
	private int skipLimit;
	private boolean isSkipExceded = false;
	
	@Override
	public boolean shouldSkip(Throwable t, int skipCount) {
		if(skipCount > skipLimit && !isSkipExceded) {
			log.error("!SKIP LIMIT EXCEDED!");
			isSkipExceded = true;
		}
		boolean skipable = false;
		if(t instanceof TP4FiltreException) {
			skipable = true;
		}
		return skipable;
	}

	public int getSkipLimit() {
		return skipLimit;
	}

	public void setSkipLimit(int skipLimit) {
		this.skipLimit = skipLimit;
	}
}