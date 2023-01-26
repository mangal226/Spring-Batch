package com.soprasteria.academy.tp7;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * A FAIRE
 * 
 * 1. Ajouter l'annotation pour utiliser le runner SPringJUnit4ClassRunner
 * 
 * 2. Ajouter l'annotation pour utiliser les contextes
 *  2.1. Déclarer le chemin d'accès au contexte du batch tp7.job.context.xml
 *  2.2. Déclarer le chemin d'accès au contexte du test tp7.test.context.xml
 *  
 * 3. injecter dans un attribut pour utiliser le bean job launcher test utils
 * 
 * 4. implementer une nouvelle méthode de test pour le step nommé "tp7Step1ID"
 *  4.1. indiquer que le contexte doit être nettoyer à chaque execution du test
 *  4.2. creer un execution contexte avec la meta data instance factory en indiquant:
 *   4.2.1. le nom du job
 *   4.2.2. le parametre "date=01/01/2000"
 *   4.2.3. l'instance id par defaut de la factory
 *   4.2.4. l'execution id par defaut de la factory
 *   
 *  4.3. faire appel au step avec le jobParameters et le jobExecutionContexte grace au job launcher test util
 *  
 *  4.4. verifier pour chaque step execution que le nombre d'element filtré est 31.
 * */
public class TP7StepTest {

    public void testStep1_OK() {
        // ARRANGE

        // ACT

        // ASSERT
    }
}
