package com.soprasteria.academy.tp5.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class TP5Decider implements JobExecutionDecider {

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        // une erreur à l'etape 1 et le batch est stoppé en erreur
        if (!stepExecution.getFailureExceptions().isEmpty()) {
            System.out.println("DECISION: ERREUR");
            return new FlowExecutionStatus("ERREUR_BATCH");
        }
        // pas de parametre d'entree et le batch est stoppé
        if (stepExecution.getJobParameters().isEmpty()) {
            System.out.println("DECISION: ARRET");
            return new FlowExecutionStatus("ARRET_BATCH");
        }
        // sinon on poursuit les etapes suivantes
        System.out.println("DECISION: POURSUITE");
        return FlowExecutionStatus.COMPLETED;
    }

}
