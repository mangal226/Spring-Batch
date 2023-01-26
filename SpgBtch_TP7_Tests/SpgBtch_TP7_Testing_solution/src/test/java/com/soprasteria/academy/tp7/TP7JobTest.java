package com.soprasteria.academy.tp7;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "/com/soprasteria/academy/tp7/tp7.test.context.xml",
    "/com/soprasteria/academy/tp7/context/tp7.job.context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TP7JobTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    @DirtiesContext
    public void testJob_OK() throws Exception {
        // ARRANGE
        JobParameters jobParameters = new JobParametersBuilder().
        										addString("date", "01/01/2000").
        										toJobParameters();

        // ACT
        JobExecution resultat = jobLauncherTestUtils.launchJob(jobParameters);

        // ASSERT
        Assert.assertEquals("Le code n'est pas celui attendu",
            new ExitStatus("CECI_EST_UN_CODE_VOLONTAIREMENT_MODIFIE"), resultat.getExitStatus());
        Assert.assertEquals("Le code n'est pas celui attendu",
            "CECI_EST_UN_CODE_VOLONTAIREMENT_MODIFIE", resultat.getExitStatus().getExitCode());        
    }

    @Test
    @DirtiesContext
    public void testJob_KO() throws Exception {
        // ARRANGE
        JobParameters myJobParametersForTest = new JobParameters();

        // ACT
        JobExecution resultat = jobLauncherTestUtils.launchJob(myJobParametersForTest);

        // ASSERT
        Assert.assertTrue("Une exception est attendu", resultat.getEndTime().compareTo(new Date(0L)) == 0);
    }
}
