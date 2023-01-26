package com.soprasteria.academy.tp3.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.soprasteria.academy.tp3.model.TP3Livre;

public class TP3Processor implements ItemProcessor<TP3Livre,TP3Livre> {

	private Logger log = LoggerFactory.getLogger(TP3Processor.class);
	
	@Override
	public TP3Livre process(TP3Livre item) throws Exception {
		int publicationYear = item.getPublicationYear();
		TP3Livre newBook = null;
		//on filtre les livres publiés apres 2000
		if (publicationYear < 2000) {
			newBook = new TP3Livre();		
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
			log.warn("Rejet du livre '{}'; Publication trop recente (annee={}).",item.getIsbn(),item.getPublicationYear());
		}
		return newBook;
	}
}