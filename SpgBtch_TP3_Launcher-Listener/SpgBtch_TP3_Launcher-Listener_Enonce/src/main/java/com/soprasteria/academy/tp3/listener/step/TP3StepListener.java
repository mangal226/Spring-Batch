package com.soprasteria.academy.tp3.listener.step;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import com.soprasteria.academy.tp3.model.TP3Livre;

/**
 * A FAIRE
 * 
 * 1. declarer l'interface d'un step execution listener
 *  1.1. implementer la methode beforeStep(.)
 *   1.1.1 afficher un message montrant l'heure de debut des step.
 *  1.2. implementer la methode afterStep(.)
 *   1.2.1 afficher le nombre d'element lu dans le step
 *   1.2.2 afficher le nombre d'element filtré dans le step
 *   1.2.3 afficher le nombre d'element ecrit dans le step
 *   1.2.4 si 50% des elements sont integré (ecriture / lecture), forcer le statut à COMPLETED (FAILED sinon)
 * 
 * 2. declarer l'interface d'un item read listener sur le model TP3Livre
 *  2.1. implementer la methode beforeRead()
 *  2.2. implementer la methode afterRead(.)
 *  2.3. implementer la methode onReadError(.)
 *  
 * 3. declarer l'interface d'un item process listener d'un model TP3Livre vers un model TP3Livre
 *  3.1. implementer la methode beforeProcess()
 *  3.2. implementer la methode afterProcess(.)
 *  3.3. implementer la methode onProcessError(.)
 *  
 * 4. declarer l'interface d'un item write listener d'un model TP3Livre
 *  3.1. implementer la methode beforeWrite()
 *  3.2. implementer la methode afterWrite(.)
 *  3.3. implementer la methode onWriteError(.)
 *  
 */
public class TP3StepListener{

	private static Logger log = LoggerFactory.getLogger("StepListener");
	private SimpleDateFormat sdfChrono = new SimpleDateFormat("HH:mm:ss");

}