package com.soprasteria.academy.tp6.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.batch.item.ItemReader;

import com.soprasteria.academy.tp6.model.TP6Livre;
import com.soprasteria.academy.tp6.model.mapper.TP6LivreMapper;

public class TP6Reader implements ItemReader<TP6Livre> {

	private BufferedReader br = null;
	
	private String input;

	private TP6LivreMapper mapper;

	public TP6Livre read() throws Exception {
		
		// ouverture du stream de lecture
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
			//on passe la premiere ligne d'entete
			br.readLine();
		}
		
		// lecture ligne a ligne
		String strLine;
		if ((strLine = br.readLine()) != null) {
			// renvoi de la ligne lue
			return getMapper().mapStringToLivre(strLine);
		}

		// sinon cloture du fichier
		br.close();
		return null;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public TP6LivreMapper getMapper() {
		return mapper;
	}

	public void setMapper(TP6LivreMapper mapper) {
		this.mapper = mapper;
	}
}