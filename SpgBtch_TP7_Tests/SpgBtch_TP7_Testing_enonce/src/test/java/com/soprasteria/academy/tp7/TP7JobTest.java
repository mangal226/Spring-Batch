package com.soprasteria.academy.tp7;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soprasteria.academy.tp7.exception.TP7ExceptionNoParams;

/**
 * A FAIRE
 * 
 * 1. Ajouter l'annotation pour utiliser le runner spring junit for class runner
 * 
 * 2. Ajouter l'annotation pour utiliser les contextes
 *  2.1. Déclarer le chemin d'accès au contexte du batch tp7.job.context.xml
 *  2.2. Déclarer le chemin d'accès au contexte du test tp7.test.context.xml
 *  
 * 3. injecter dans un attribut pour utiliser le bean job launcher test utils
 * 
 * 4. Implementer 2 nouvelles methodes de test
 *  4.1. dans une  premiere méthode de test
 *   4.1.1. creer un nouveau JobParametersBuilder
 *   4.1.2. y injecter un parametre nommé "date" avec la valeur "01/01/2000"
 *   4.1.3. executer le job avec son jobParameters grace au job launcher test util
 *   4.1.4. vérifier que le code de sortie est "CECI_EST_UN_CODE_VOLONTAIREMENT_MODIFIE"
 * 
 *  4.2. dans la deuxieme méthode de test
 *   4.1.1. creer un jobparameter vide
 *   4.1.2. executer le job avec son jobParameters vide grace au job launcher test util
 *   4.1.4. vérifier que la date de fin est le 01 janvier 1970 (new Date(0L))
 *   
 * 5. verifier que les deux methodes de tests s'executent sans 
 *  5.1. utiliser l'annotation dirties context pour resoudre les eventuels problèmes de contexte.
 */
public class TP7JobTest {

    public void testJob_OK() throws Exception {
        // ARRANGE

        // ACT

        // ASSERT

    }

    public void testJob_KO() throws Exception {
        // ARRANGE

        // ACT

        // ASSERT
    }
}
