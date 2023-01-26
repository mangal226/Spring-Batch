package com.soprasteria.academy.tp3.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * A FAIRE
 * 
 * 1. declarer l'interface d'un job execution listener
 * 2. implementer la methodes beforeJob(.)
 *  2.1. utiliser le logger fourni pour afficher le demarrage du job
 * 3. implementer la methode afterJob(.)
 *  3.1. utiliser le logger fourni pour afficher la fin de l'integration des livres
 *  3.2. utiliser le logger et les formateurs pour afficher la date/heure de debut du batch
 *  3.3. utiliser le logger et les formateurs pour afficher la date/heure de fin du batch
 *  3.4. recuperer la liste des erreurs et en afficher le nombre.
 */
public class TP3JobListener {

	private static final Logger LOGGER = LoggerFactory.getLogger("Job Listener");
	private SimpleDateFormat sdfDate = new SimpleDateFormat("dd MMM yyyy");
	private SimpleDateFormat sdfChrono = new SimpleDateFormat("HH:mm:ss");
	
	


}
