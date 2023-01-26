package com.soprasteria.academy.tp5.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 *  A FAIRE
 *
 * 1. Déclarer que cette classe est une implémentation d'un job execution decider
 * 2. Ajouter la méthode decide(.) et y implémenter les traitements suivants:
 *  2.1. si le step execution contient au moins une exception:
 *  2.2. afficher un log
 *  2.3. retourner un nouveau statut de flow 'ERREUR_BATCH'

 *  2.4. si le job parameters est vide:
 *  2.5. afficher un log
 *  2.6. retourner un nouveau statut de flow 'ARRET_BATCH'
 *  
 *  2.7. dans les autre cas, indiquer que le batch peut se poursuivre avec un log et un statut de flow standardisé.
 *
 */
public class TP5Decider {

}
