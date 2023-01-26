package com.soprasteria.academy.tp4.listener.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

public class TP4RetryListener implements RetryListener{

	private static Logger log = LoggerFactory.getLogger("SkipListener");
	
	
	public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
		log.debug("open");
		return true;
	}

	public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
			Throwable throwable) {
		log.debug("close");
	}

	public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
			Throwable throwable) {
		log.debug("onError");
	}

}
