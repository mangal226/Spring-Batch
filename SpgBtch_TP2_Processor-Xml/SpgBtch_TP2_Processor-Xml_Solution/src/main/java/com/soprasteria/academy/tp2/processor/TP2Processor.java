package com.soprasteria.academy.tp2.processor;

import org.springframework.batch.item.ItemProcessor;

import com.soprasteria.academy.tp2.model.TP2Livre;

public class TP2Processor implements ItemProcessor<TP2Livre, TP2Livre> {

	@Override
	public TP2Livre process(TP2Livre item) throws Exception {
		int publicationYear = item.getPublicationYear();
		TP2Livre newBook = null;
		//on filtre les livres publiés apres 2000
		if (publicationYear < 2000) {
			// création nouvel objet TP2Livre, important dans le cas mise en oeuvre mécanisme de rejeu (cf. plus tard)
			newBook = new TP2Livre();
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