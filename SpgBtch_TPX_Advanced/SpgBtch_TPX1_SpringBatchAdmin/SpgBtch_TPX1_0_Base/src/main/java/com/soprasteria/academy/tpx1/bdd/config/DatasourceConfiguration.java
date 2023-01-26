package com.soprasteria.academy.tpx1.bdd.config;

import java.sql.Driver;
import java.util.List;

import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DatasourceConfiguration {

	@Value("${db.driver:org.h2.Driver}")
	private Class<Driver> driver;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username:sa}")
	private String username;

	@Value("${db.password:}")
	private String password;
	
	@Value("${db.script-create-business.location}")
	private String businessSqlFilePath;

	@Value("${db.script-create-springBatch.location}")
	private String springBatchSqlFilePath;

	@Value("${db.script-create-springCloudTask.location}")
	private String springCloudTaskSqlFilePath; 

	@Value("${db.script-create-springCloudDataFlow.location}")
	private String[] springCloudDataFlowSqlFilePaths; 

	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	

	@Bean
	@Profile("createDB")
    public DataSourceInitializer addBusinessSupport(DataSource dataSource) {
		return createDataSourceInitializer(dataSource, businessSqlFilePath);
	}
	
	@Bean
	@Profile("updateDB_SpringBatch")
    public DataSourceInitializer addSpringBatchSupport(DataSource dataSource) {
		return createDataSourceInitializer(dataSource, springBatchSqlFilePath);
	}

	@Bean
	@Profile("updateDB_SpringCloudTask")
    public DataSourceInitializer addSpringCloudTaskSupport(DataSource dataSource) {
		return createDataSourceInitializer(dataSource, springCloudTaskSqlFilePath);
	}

	@Bean
	@Profile("updateDB_SpringCloudDataFlow")
    public DataSourceInitializer addSpringCloudDataFlowSupport(DataSource dataSource) {
		return createDataSourceInitializer(dataSource, springCloudDataFlowSqlFilePaths);
	}
	
	private DataSourceInitializer createDataSourceInitializer(DataSource dataSource, String... sqlScripts) {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		for(String sqlScript:sqlScripts) {
			databasePopulator.addScripts(new ClassPathResource(sqlScript));
		}
		
    	DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		return dataSourceInitializer;
	}

	
	@Bean
	@DependsOn("dataSource")
	@Profile("monitorDB")
	public MethodInvokingBean databaseConsole() {
		String urlConsole = url.split(";")[0];

		MethodInvokingBean methodInvokingBean = new MethodInvokingBean();
		methodInvokingBean.setTargetClass(DatabaseManagerSwing.class);
		methodInvokingBean.setTargetMethod("main");
		methodInvokingBean.setArguments(new Object[] {
				"--driver", driver.getName(),
				"--url", urlConsole,
				"--user", username,
				"--password", password
		});
		return methodInvokingBean;
	}
	
}
