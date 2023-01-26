package com.soprasteria.academy.tp2.processor;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

import com.soprasteria.academy.tp2.model.TP2Livre;

public class PublicationYearValidator implements Validator<TP2Livre> {

	@Override
	public void validate(TP2Livre livre) throws ValidationException {
		int publicationYear = livre.getPublicationYear();
		if (publicationYear >= 2000) {
			throw new ValidationException("date de pubication du livre " + livre.getIsbn() + " est > 2000");
		}

	}
}
