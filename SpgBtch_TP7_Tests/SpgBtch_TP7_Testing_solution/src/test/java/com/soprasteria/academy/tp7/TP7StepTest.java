package com.soprasteria.academy.tp7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "/com/soprasteria/academy/tp7/tp7.test.context.xml",
    "/com/soprasteria/academy/tp7/context/tp7.job.context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TP7StepTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    @DirtiesContext
    public void testStep1_OK() {
        // ARRANGE
        String jobName = "tp7JobID";
        String jobParametersList = "date=01/01/2000";
        String stepName = "tp7Step1ID";

        JobExecution jobExecution =
            MetaDataInstanceFactory.createJobExecution(jobName, MetaDataInstanceFactory.DEFAULT_JOB_INSTANCE_ID,
                MetaDataInstanceFactory.DEFAULT_JOB_EXECUTION_ID, jobParametersList);

        ExecutionContext jobExecutionContext = jobExecution.getExecutionContext();
        JobParameters jobParameters = jobExecution.getJobParameters();

        // ACT
        JobExecution resultat = jobLauncherTestUtils.launchStep(stepName, jobParameters, jobExecutionContext);

        // ASSERT
        for (StepExecution stepsExec : resultat.getStepExecutions()) {
            Assert.assertTrue("Le nombre d'elements filtrés est incorrect!", stepsExec.getFilterCount() == 31);
        }
    }
}
