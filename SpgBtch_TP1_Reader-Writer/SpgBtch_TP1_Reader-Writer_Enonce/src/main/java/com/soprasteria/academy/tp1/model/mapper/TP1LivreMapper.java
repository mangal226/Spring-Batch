package com.soprasteria.academy.tp1.model.mapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.soprasteria.academy.tp1.model.TP1Livre;

public final class TP1LivreMapper {

	private Pattern patt = Pattern.compile("(.*)[|](.*)[|](\\d{4})[|](.*)[|](\\d{2}[.]\\d{2})[|](\\d)");
	private String separator = "|";

	public TP1Livre mapStringToLivre(String strLine) {
		Matcher match = patt.matcher(strLine);
		if (!match.matches()) {
			throw new IllegalArgumentException("Ligne rejetee!");
		}
		TP1Livre newLivre = new TP1Livre();
		newLivre.setTitle(match.group(1));
		newLivre.setAuthor(match.group(2));
		newLivre.setPublicationYear(Integer.parseInt(match.group(3)));
		newLivre.setIsbn(match.group(4));
		newLivre.setEuroPrices(Double.parseDouble(match.group(5)));
		newLivre.setStock(Integer.parseInt(match.group(6)));
		return newLivre;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}
}
