package com.soprasteria.academy.tpx1.job.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.soprasteria.academy.tpx1.bdd.config.DatasourceConfiguration;

@Configuration
@EnableBatchProcessing
@Import({ DatasourceConfiguration.class, JobConfiguration.class })
@PropertySources({
	@PropertySource(
	        value={"classpath:/com/soprasteria/academy/tpx1/bdd/tpx1.bdd.properties"},
	        ignoreResourceNotFound = false),
	@PropertySource(
	        value={"classpath:/com/soprasteria/academy/tpx1/job/tpx1.job.properties"},
	        ignoreResourceNotFound = false),
})
public class MainConfiguration {

}
