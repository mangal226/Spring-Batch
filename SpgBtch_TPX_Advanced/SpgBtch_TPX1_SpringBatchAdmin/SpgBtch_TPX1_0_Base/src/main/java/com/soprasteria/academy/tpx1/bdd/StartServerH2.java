package com.soprasteria.academy.tpx1.bdd;

import static com.soprasteria.academy.tpx1.bdd.MainSpringContext.runWithMainConfiguration;

public class StartServerH2 {

	public static void main(String[] args) {
		runWithMainConfiguration("h2", "startDB");
	}
	
}
