package com.soprasteria.academy.tp4.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.soprasteria.academy.tp4.exception.TP4FiltreException;
import com.soprasteria.academy.tp4.model.TP4Livre;

public class TP4Writer implements ItemWriter<TP4Livre> {

	private ItemWriter<TP4Livre> delegate;

	@Override
	public void write(List<? extends TP4Livre> items) throws Exception {
		for(TP4Livre item:items) {
			if (item.getPublicationYear() > 2000) {
				throw new TP4FiltreException("Rejet du livre: Publication trop recente.", item.getIsbn(), item.getPublicationYear());
			}
		}
		
		delegate.write(items);
	}

	public void setDelegate(ItemWriter<TP4Livre> delegate) {
		this.delegate = delegate;
	}

}
