package com.soprasteria.academy.tpx1.job;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

import com.soprasteria.academy.tpx1.job.config.MainConfiguration;

public class LaunchTpx1Job {

	public static void main(String[] args) throws Exception {
		String springConfiguration = MainConfiguration.class.getName();
		String jobName = "tpx1Job";
		String[] commandLineArguments = {springConfiguration, jobName, };
		CommandLineJobRunner.main(commandLineArguments);
	}

}
