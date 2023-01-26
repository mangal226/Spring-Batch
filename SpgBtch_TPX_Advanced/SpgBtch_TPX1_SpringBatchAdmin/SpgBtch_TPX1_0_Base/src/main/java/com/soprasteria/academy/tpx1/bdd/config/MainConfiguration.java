package com.soprasteria.academy.tpx1.bdd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({BaseH2Configuration.class, DatasourceConfiguration.class})
@PropertySource(
        value={"classpath:/com/soprasteria/academy/tpx1/bdd/tpx1.bdd.properties"},
        ignoreResourceNotFound = false)
public class MainConfiguration {

	/**
	 * For resolution of "${property:default_value}" expression on @Value.
	 * NB: method must be static, otherwise @Autowired not working (cf. following warning is displayed in console :
	 * AVERTISSEMENT: @Bean method JobConfiguration.propertySourcesPlaceholderConfigurer is non-static and returns an object assignable to Spring's BeanFactoryPostProcessor interface. This will result in a failure to process annotations such as @Autowired, @Resource and @PostConstruct within the method's declaring @Configuration class. Add the 'static' modifier to this method to avoid these container lifecycle issues; see @Bean javadoc for complete details 
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
