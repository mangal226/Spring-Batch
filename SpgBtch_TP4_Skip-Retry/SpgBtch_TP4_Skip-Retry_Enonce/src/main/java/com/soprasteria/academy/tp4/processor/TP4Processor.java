package com.soprasteria.academy.tp4.processor;

import org.springframework.batch.item.ItemProcessor;

import com.soprasteria.academy.tp4.exception.TP4FiltreException;
import com.soprasteria.academy.tp4.model.TP4Livre;

/**
 * A FAIRE
 * 1. implementer: si la publicationYear ne precede pas 2001, emettre une exception de type TP4FiltreException.
 * 1.2. sinon retourner l'objet.
 */
public class TP4Processor implements ItemProcessor<TP4Livre, TP4Livre> {

    @Override
    public TP4Livre process(TP4Livre item) throws Exception {
        TP4Livre newBook = new TP4Livre();
        // mapping direct
        newBook.setIsbn(item.getIsbn());
        newBook.setAuthor(item.getAuthor());
        newBook.setTitle(item.getTitle());
        newBook.setPublicationYear(item.getPublicationYear());
        newBook.setStock(item.getStock());
        // champ calculé
        newBook.setEstimationTotal(item.getEuroPrices() * item.getStock());
        newBook.setRare(item.getPublicationYear() < 1945);
        return newBook;
    }
}