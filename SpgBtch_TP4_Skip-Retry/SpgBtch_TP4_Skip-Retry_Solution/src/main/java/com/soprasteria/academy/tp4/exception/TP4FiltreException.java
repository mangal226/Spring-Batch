package com.soprasteria.academy.tp4.exception;

public class TP4FiltreException extends Exception {

	private static final long serialVersionUID = 1L;

	private final int publicationYear;
	private final String isbn;
	private final String why;

	public TP4FiltreException(String why, String isbn, int publicationYear) {
		this.why = why;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
	}

	@Override
	public String toString() {
		return "TP4FiltreException [" + why + " on " + isbn + "(publicationYear=" + publicationYear + ")]";
	}

	public String getIsbn() {
		return isbn;
	}

}
