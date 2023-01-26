package com.soprasteria.academy.tp5.tasklet;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * A FAIRE
 *
 * 1. Ajouter les attributs :
 *  1.1. dataSource qui reference la dataSource 
 *  1.2. sql qui est la requete de lecture du nombre de donnée en bdd
 *  1.3. outputFileName qui est le nom du rapport à generer.
 * 
 * 2. Declarer cette classe comme implementation d'un tasklet
 *  2.1. Ajouter la méthode execute(.)
 *  2.2. Executer la requete de lecture du nombre d'element en base de donnée et l'inscrire dans un fichier texte
 *  2.3. Une fois terminé, retourner le status terminé d'un tasklet.
 *  
 */
public class TP5TaskletSplit1 {

}
