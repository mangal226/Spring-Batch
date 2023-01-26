package com.soprasteria.academy.tpx1.job.processor;

import org.springframework.batch.item.ItemProcessor;

import com.soprasteria.academy.tpx1.job.model.TPX1Livre;

public class TPX1Processor implements ItemProcessor<TPX1Livre, TPX1Livre> {

	@Override
	public TPX1Livre process(TPX1Livre item) throws Exception {
		int publicationYear = item.getPublicationYear();
		TPX1Livre newBook = null;
		//on filtre les livres publiés apres 2000
		if (publicationYear < 2000) {
			newBook = new TPX1Livre();
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
