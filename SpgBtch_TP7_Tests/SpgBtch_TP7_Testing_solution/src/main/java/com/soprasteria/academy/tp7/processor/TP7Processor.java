package com.soprasteria.academy.tp7.processor;

import org.springframework.batch.item.ItemProcessor;

import com.soprasteria.academy.tp7.model.TP7Livre;

public class TP7Processor implements ItemProcessor<TP7Livre,TP7Livre> {

	
	@Override
	public TP7Livre process(TP7Livre item) throws Exception {
		int publicationYear = item.getPublicationYear();
		TP7Livre newBook = null;
		//on filtre les livres publies apres 2000
		if (publicationYear <= 2000) {
			newBook = new TP7Livre();		
			// mapping direct
			newBook.setIsbn(item.getIsbn());
			newBook.setAuthor(item.getAuthor());
			newBook.setTitle(item.getTitle());
			newBook.setPublicationYear(publicationYear);
			newBook.setStock(item.getStock());
			// champ calculé
			newBook.setEstimationTotal(item.getEuroPrices() * item.getStock());
			newBook.setRare(publicationYear < 1945);
		}
		return newBook;
	}
}