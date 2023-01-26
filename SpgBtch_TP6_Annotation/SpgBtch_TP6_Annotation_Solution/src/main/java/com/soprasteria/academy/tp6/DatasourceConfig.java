package com.soprasteria.academy.tp6;

import javax.sql.DataSource;

import org.h2.Driver;
import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.config.MethodInvokingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * Classe de configuration des objets de base de données.
 */
@Configuration
public class DatasourceConfig {

	/**
	 * Initialisation d'un SimpleDriverDataSource d'un base h2 en mémoire.
	 * @return DataSource
	 */
	@Bean
	public DataSource dataSourceID() {
		final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new Driver());
		dataSource.setUrl("jdbc:h2:mem:dataSource;MODE=Oracle;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("");
		dataSource.setPassword("");
		// Alternative à la méthode dataSourceInitializer :
		// DatabasePopulatorUtils.execute(databasePopulator(), dataSource);
		return dataSource;
	}

	/**
	 * Initialisation de la datasource
	 * @param dataSource la datasource à créer
	 * @return DataSourceInitializer
	 */
	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

	/**
	 * Ajout des scripts d'initialisation de la datasource
	 * @return DatabasePopulator
	 */
	private DatabasePopulator databasePopulator() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("org/springframework/batch/core/schema-h2.sql"));
		populator.addScript(new ClassPathResource("com/soprasteria/academy/tp6/bdd/tp6.create-db.sql"));
		return populator;
	}

	/**
	 * Initialisation de la console Swing d'accès à la base.
	 */
	@Bean
	@DependsOn("dataSourceID")
	@Profile("monitor")
	public MethodInvokingBean databaseConsole() {
		MethodInvokingBean methodInvokingBean = new MethodInvokingBean();
		methodInvokingBean.setTargetClass(DatabaseManagerSwing.class);
		methodInvokingBean.setTargetMethod("main");
		methodInvokingBean.setArguments(new Object[] {
				"--url", "jdbc:h2:mem:dataSource",
				"--user", "",
				"--password", ""
		});
		return methodInvokingBean;
	}

}
