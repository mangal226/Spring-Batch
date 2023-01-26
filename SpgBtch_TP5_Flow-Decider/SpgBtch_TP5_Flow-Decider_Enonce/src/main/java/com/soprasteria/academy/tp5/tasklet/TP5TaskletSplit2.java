package com.soprasteria.academy.tp5.tasklet;

import java.text.MessageFormat;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * A FAIRE
 * 
 * 1. Déclarer cette classe comme une implémentation de tasklet.
 * 
 * 2. Ajouter une chaine de caractere pour injecter depuis la configuration le nom du flow qui execute cette implementation.
 * 
 * 3. Ajouter la méthode execute(.)
 *  3.1. a chaque iteration
 *   3.1.1. afficher le nom du flow et le compteur d'element ecrit dans stocké dans le stepExecutionContext (utiliser le parametre ChunkContext)
 *   3.1.2. incrementer le compteur d'element ecrit (utiliser le parametre stepContribution)
 *   
 *  3.2. conditionner le statut de sortie du tasklet
 *    3.2.1. recuperer le compteur d'elements ecrits stocké dans le stepExecutionContext
 *    3.2.2. le tasklet doit continuer tant que le compteur est inférieur à 1000
 */
public class TP5TaskletSplit2 {
    
}