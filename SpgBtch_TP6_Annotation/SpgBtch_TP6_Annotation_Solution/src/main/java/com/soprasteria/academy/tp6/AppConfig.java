package com.soprasteria.academy.tp6;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.soprasteria.academy.tp6.model.TP6Livre;
import com.soprasteria.academy.tp6.model.mapper.TP6LivreMapper;
import com.soprasteria.academy.tp6.reader.TP6Reader;
import com.soprasteria.academy.tp6.writer.TP6Writer;

/**
 * Indique que cette classe déclare des méthodes de type @Bean
 */
@Configuration
/**
 * Activation des fonctionnalités Spring Batch et initialisation d'une configuration Spring Batch basique
 */
@EnableBatchProcessing
/**
 * Ajout de la classe de configuration de la datasource
 */
@Import(DatasourceConfig.class)
/**
 * Configuration et chargement du fichier de propriétés
 */
@PropertySource(
        value={"classpath:com/soprasteria/academy/tp6/bdd/tp6.sql.properties"},
        ignoreResourceNotFound = false)
/**
 * Classe principale de la configuration Spring Batch
 */
public class AppConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Autowired
	private DataSource dataSourceID;

	@Value("${tp6JobID.tp6StepID.commit-interval:10}")
	private int chunkSize;

	@Value("${bibliotheque.query.insert}")
	private String query;
	
	/**
	 * Création du Job
	 * @param tp6StepID le step du job
	 * @return Job
	 */
	@Bean
	public Job tp6JobID(@Qualifier("tp6StepID") Step tp6StepID) {
		return jobs.get("tp6JobID").start(tp6StepID).build();
	}

	/**
	 * Création d'un Step de type chunk
	 * @param reader Le reader du step
	 * @param writer Le writer du step
	 * @return Step
	 */
	@Bean
	protected Step tp6StepID(ItemReader<TP6Livre> reader, ItemWriter<TP6Livre> writer) {
		return steps.get("tp6StepID").<TP6Livre, TP6Livre>chunk(10).reader(reader).writer(writer).build();
	}

	/**
	 * Création d'un ItemReader
	 * @return ItemReader
	 */
	@Bean
	public ItemReader<TP6Livre> tp6ReaderID() {
		TP6Reader reader = new TP6Reader();
		reader.setInput("src/main/resources/input/tp6_bibliotheque.csv");
		reader.setMapper(new TP6LivreMapper());
		return reader;
	}

	/**
	 * Création d'un ItemWriter
	 * @param dataSource La datasource utilisée par le writer
	 * @return ItemWriter
	 */
	@Bean
	public ItemWriter<TP6Livre> tp6WriterID() {
		TP6Writer writer = new TP6Writer();
		writer.setDataSource(dataSourceID);
		writer.setQuery(query);
		return writer;
	}

}
