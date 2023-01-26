package com.soprasteria.academy.tpx1.job.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.soprasteria.academy.tpx1.job.model.TPX1Livre;

@Configuration
@Import({ReaderConfiguration.class, ProcessorConfiguration.class, WriterConfiguration.class, TaskletConfiguration.class})
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Value("${tpx1Job.tpx1Step.commit-interval:10}")
	private int chunkSize;
	
	@Autowired
	private ItemReader<TPX1Livre> reader;

	@Autowired
	private ItemProcessor<TPX1Livre, TPX1Livre> processor;

	@Autowired
	private ItemWriter<TPX1Livre> writer;

	@Autowired
	private Tasklet tasklet;
	
	/**
	 * For resolution of "${property:default_value}" expression on @Value.
	 * NB: method must be static, otherwise @Autowired not working (cf. following warning is displayed in console :
	 * AVERTISSEMENT: @Bean method JobConfiguration.propertySourcesPlaceholderConfigurer is non-static and returns an object assignable to Spring's BeanFactoryPostProcessor interface. This will result in a failure to process annotations such as @Autowired, @Resource and @PostConstruct within the method's declaring @Configuration class. Add the 'static' modifier to this method to avoid these container lifecycle issues; see @Bean javadoc for complete details 
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name="tpx1Job")
	public Job job() {
		return jobBuilderFactory.get("tpx1Job")
				.start(step())
				.build();
	}
	
	@Bean
	public Step step() {
		return stepBuilderFactory.get("tpx1Step")
					.<TPX1Livre, TPX1Livre>chunk(chunkSize)
						.reader(reader)
						.processor(processor)
						.writer(writer)
					.build();
	}
	
	@Bean(name="tpx1Job2")
	public Job job2() {
		return jobBuilderFactory.get("tpx1Job2")
				.start(step2())
				.build();
	}
	
	@Bean
	public Step step2() {
		return stepBuilderFactory.get("tpx1Step2")
				.tasklet(tasklet)
				.build();
	}
	
}
