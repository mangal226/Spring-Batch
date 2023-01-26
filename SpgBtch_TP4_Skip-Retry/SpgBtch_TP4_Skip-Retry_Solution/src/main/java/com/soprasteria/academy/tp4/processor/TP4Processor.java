package com.soprasteria.academy.tp4.processor;

import org.springframework.batch.item.ItemProcessor;

import com.soprasteria.academy.tp4.exception.TP4FiltreException;
import com.soprasteria.academy.tp4.model.TP4Livre;

public class TP4Processor implements ItemProcessor<TP4Livre,TP4Livre> {

	private boolean filterInProcessor = true;

	@Override
	public TP4Livre process(TP4Livre item) throws Exception {
		int publicationYear = item.getPublicationYear();
		TP4Livre newBook = null;
		//on filtre les livres publiés apres 2000
		if (publicationYear <= 2000) {
			newBook = new TP4Livre();		
			// mapping direct
			newBook.setIsbn(item.getIsbn());
			newBook.setAuthor(item.getAuthor());
			newBook.setTitle(item.getTitle());
			newBook.setPublicationYear(publicationYear);
			newBook.setStock(item.getStock());
			// champ calculé
			newBook.setEstimationTotal(item.getEuroPrices() * item.getStock());
			newBook.setRare(publicationYear < 1945);
		}else {
			newBook = item;
			if (filterInProcessor) {
				throw new TP4FiltreException("Rejet du livre: Publication trop recente.", item.getIsbn(), item.getPublicationYear());
			}
		}
		return newBook;
	}

	public void setFilterInProcessor(boolean filterInProcessor) {
		this.filterInProcessor = filterInProcessor;
	}
}
