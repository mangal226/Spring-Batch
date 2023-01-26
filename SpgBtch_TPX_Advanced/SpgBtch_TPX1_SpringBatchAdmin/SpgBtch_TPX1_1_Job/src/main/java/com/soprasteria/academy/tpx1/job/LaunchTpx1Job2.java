package com.soprasteria.academy.tpx1.job;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

import com.soprasteria.academy.tpx1.job.config.MainConfiguration;

public class LaunchTpx1Job2 {

	public static void main(String[] args) throws Exception {
		String springConfiguration = MainConfiguration.class.getName();
		String jobName = "tpx1Job2";
		String[] commandLineArguments = {springConfiguration, jobName, "msg=coucou"};
		CommandLineJobRunner.main(commandLineArguments);
	}

}
