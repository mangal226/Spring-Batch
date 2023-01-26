package com.soprasteria.academy.tp4.listener.step;

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

import com.soprasteria.academy.tp4.model.TP4Livre;

/**
 * A FAIRE
 * 
 * 1. declarer ce listener comme une implementation d'un step execution listener
 *  1.1. creer un attribut pour garder la reference au step execution.
 *  1.2. avant d'executer un step, stocker la reference du step execution.
 *  
 * 2. declarer ce listener comme une implementation d'un item read listener
 *  2.1. si une erreur survient à la lecture, ajouter cette erreur dans le contexte d'execution referencé
 *  
 * 3. declarer ce listener comme une implementation d'un item processor listener
 *  3.1. si une erreur survient à la transformation, ajouter cette erreur dans le contexte d'execution referencé
 *  
 * 4. declarer ce listener comme une implementation d'un item write listener
 *  4.1. si une erreur survient à l'ecriture, ajouter cette erreur dans le contexte d'execution referencé
 */
public class TP4Step1Listener {

	private static Logger log = LoggerFactory.getLogger("StepListener");
	private SimpleDateFormat sdfChrono = new SimpleDateFormat("HH:mm:ss");


}