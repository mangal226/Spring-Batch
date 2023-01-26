package com.soprasteria.academy.tpx1.job.config;

import org.apache.commons.io.Charsets;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.soprasteria.academy.tpx1.job.model.TPX1Livre;

@Configuration
public class ReaderConfiguration {

	@Value("${reader.file.location}")
	private String filePath;
	
	@Bean
	@StepScope
	public FlatFileItemReader<TPX1Livre> reader() {
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] {"title", "author", "publicationyear", "isbn", "europrice", "stock"});

		DefaultLineMapper<TPX1Livre> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper());

		FlatFileItemReader<TPX1Livre> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new ClassPathResource(filePath));
		itemReader.setEncoding(Charsets.UTF_8.name());
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper);

		return itemReader;
	}
	
	@Bean
	public FieldSetMapper<TPX1Livre> fieldSetMapper() {
		BeanWrapperFieldSetMapper<TPX1Livre> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(TPX1Livre.class);
		return fieldSetMapper;
	}
	
}
