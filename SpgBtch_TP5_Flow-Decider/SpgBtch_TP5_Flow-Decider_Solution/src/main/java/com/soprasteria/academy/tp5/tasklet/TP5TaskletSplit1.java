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

public class TP5TaskletSplit1 implements Tasklet {

    private DataSource db;

    private String sql;

    private String outputFileName;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        try (Connection connection = db.getConnection(); 
    		PreparedStatement pstmt = connection.prepareStatement(sql);
    		ResultSet rset = pstmt.executeQuery()
		) {
            if (rset.next()) {
                try (FileOutputStream fos = new FileOutputStream(new File(outputFileName))) {
                    fos.write(MessageFormat.format("Il y a {0} elements enregistres.", rset.getInt(1))
                        .getBytes());
                }
            }
        }
        return RepeatStatus.FINISHED;
    }

    public void setDb(DataSource db) {
        this.db = db;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

}
