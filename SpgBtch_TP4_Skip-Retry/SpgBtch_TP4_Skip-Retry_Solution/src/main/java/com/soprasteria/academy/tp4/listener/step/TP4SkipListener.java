package com.soprasteria.academy.tp4.listener.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

import com.soprasteria.academy.tp4.exception.TP4FiltreException;
import com.soprasteria.academy.tp4.model.TP4Livre;

public class TP4SkipListener implements SkipListener<TP4Livre, TP4Livre> {

	private static Logger log = LoggerFactory.getLogger("SkipListener");
	
	private int skipNumber = 0;
	
	
	@Override
	public void onSkipInProcess(TP4Livre item, Throwable t) {
		log.debug("onSkipInProcess {} on {}", (++skipNumber), item.getIsbn());
	}
	
	@Override
	public void onSkipInRead(Throwable t) {
		if (TP4FiltreException.class.isInstance(t)) {
			log.debug("onSkipInRead {} on {}", (++skipNumber), TP4FiltreException.class.cast(t).getIsbn());
		}
	}
	
	@Override
	public void onSkipInWrite(TP4Livre item, Throwable t) {
		log.debug("onSkipInWrite {} on {}", (++skipNumber), item.getIsbn());
	}
}
