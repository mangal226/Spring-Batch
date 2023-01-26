package com.soprasteria.academy.tpx1.bdd.config;

import org.h2.tools.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("h2")
public class BaseH2Configuration {

	@Value("${h2.baseDir}")
	private String baseDir;

	@Value("${h2.tcpPort:9092}")
	private int tcpPort;

	@Value("${h2.webPort:8082}")
	private int webPort;

	@Bean
	@Profile("startDB")
	public MethodInvokingBean startServerH2() {
		MethodInvokingBean methodInvokingBean = new MethodInvokingBean();
		methodInvokingBean.setTargetClass(Console.class);
		methodInvokingBean.setTargetMethod("main");
		methodInvokingBean.setArguments(new Object[] {
				"-tcp", "-tcpAllowOthers", "-tcpPort", tcpPort,
				"-web", "-webPort", webPort,
				"-baseDir", baseDir,
				
		});
		return methodInvokingBean;
	}
	
	@Bean
	@Profile("stopDB")
	public MethodInvokingBean stopServerH2() {
		MethodInvokingBean methodInvokingBean = new MethodInvokingBean();
		methodInvokingBean.setTargetClass(Console.class);
		methodInvokingBean.setTargetMethod("main");
		methodInvokingBean.setArguments(new Object[] {
				"-tcp", "-tcpShutdown", "-tcpPort", tcpPort,
				"-baseDir", baseDir,
		});
		return methodInvokingBean;
	}

}
