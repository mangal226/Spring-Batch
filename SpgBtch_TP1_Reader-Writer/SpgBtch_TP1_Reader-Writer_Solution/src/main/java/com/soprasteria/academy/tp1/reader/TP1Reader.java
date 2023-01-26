package com.soprasteria.academy.tp1.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.batch.item.ItemReader;

import com.soprasteria.academy.tp1.model.TP1Livre;
import com.soprasteria.academy.tp1.model.mapper.TP1LivreMapper;

public class TP1Reader implements ItemReader<TP1Livre> {

	private BufferedReader br = null;
	
	private String input;

	private TP1LivreMapper mapper;

	public TP1Livre read() throws Exception {
		
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

	public TP1LivreMapper getMapper() {
		return mapper;
	}

	public void setMapper(TP1LivreMapper mapper) {
		this.mapper = mapper;
	}
}