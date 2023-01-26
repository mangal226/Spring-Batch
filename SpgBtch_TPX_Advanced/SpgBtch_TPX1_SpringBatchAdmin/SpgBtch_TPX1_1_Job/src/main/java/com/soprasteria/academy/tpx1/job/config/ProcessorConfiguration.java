package com.soprasteria.academy.tpx1.job.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soprasteria.academy.tpx1.job.model.TPX1Livre;
import com.soprasteria.academy.tpx1.job.processor.TPX1Processor;

@Configuration
public class ProcessorConfiguration {

	@Bean
	public ItemProcessor<TPX1Livre, TPX1Livre> processor() {
		return new TPX1Processor();
	}
}
