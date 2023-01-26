package com.soprasteria.academy.tpx1.job.config;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soprasteria.academy.tpx1.job.model.TPX1Livre;

@Configuration
public class WriterConfiguration {

	@Autowired
	private DataSource dataSource;
	
	@Value("${writer.query.insert}")
	private String sql;
	
	@Bean
	public ItemWriter<TPX1Livre> writer() {
		JdbcBatchItemWriter<TPX1Livre> itemWriter = new JdbcBatchItemWriter<>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(sql);
		itemWriter.setItemSqlParameterSourceProvider(itemSqlParameterSourceProvider());
		return itemWriter;
	}
	
	@Bean
	public ItemSqlParameterSourceProvider<TPX1Livre> itemSqlParameterSourceProvider() {
		return new BeanPropertyItemSqlParameterSourceProvider<>();
	}
}
