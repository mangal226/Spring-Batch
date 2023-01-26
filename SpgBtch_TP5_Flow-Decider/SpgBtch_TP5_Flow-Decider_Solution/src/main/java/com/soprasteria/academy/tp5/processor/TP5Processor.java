package com.soprasteria.academy.tp5.processor;

import org.springframework.batch.item.ItemProcessor;

import com.soprasteria.academy.tp5.model.TP5Livre;

public class TP5Processor implements ItemProcessor<TP5Livre,TP5Livre> {

	
	@Override
	public TP5Livre process(TP5Livre item) throws Exception {
		int publicationYear = item.getPublicationYear();
		TP5Livre newBook = null;
		//on filtre les livres publies apres 2000
		if (publicationYear <= 2000) {
			newBook = new TP5Livre();		
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