package com.soprasteria.academy.tp4.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.soprasteria.academy.tp4.exception.TP4FiltreException;
import com.soprasteria.academy.tp4.model.TP4Livre;

public class TP4Reader implements ItemReader<TP4Livre> {

	private boolean filterInReader;
	
	private ItemReader<TP4Livre> delegate;
	
	@Override
	public TP4Livre read() throws Exception, UnexpectedInputException, ParseException {
		TP4Livre item = delegate.read();

		if (filterInReader && item !=null && item.getPublicationYear()>2000) {
			throw new TP4FiltreException("Rejet du livre: Publication trop recente.", item.getIsbn(), item.getPublicationYear());
		}
		return item;
	}

	public void setFilterInReader(boolean filterInReader) {
		this.filterInReader = filterInReader;
	}
	
	public void setDelegate(ItemReader<TP4Livre> delegate) {
		this.delegate = delegate;
	}

}
