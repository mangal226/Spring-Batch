package com.soprasteria.academy.tp7.model;

import java.io.Serializable;

public class TP7Livre implements Serializable {
	private static final long serialVersionUID = 1L;

	private String isbn;
	private String title;
	private String author;
	private int publicationYear;
	private double euroPrices;
	private int stock;

	private double estimationTotal;
	private boolean rare;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public double getEuroPrices() {
		return euroPrices;
	}

	public void setEuroPrices(double euroPrices) {
		this.euroPrices = euroPrices;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getEstimationTotal() {
		return estimationTotal;
	}

	public void setEstimationTotal(double estimationTotal) {
		this.estimationTotal = estimationTotal;
	}

	public boolean isRare() {
		return rare;
	}

	public void setRare(boolean rare) {
		this.rare = rare;
	}

}
