package com.mediscreen.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssessmentApplication {

	/**
	 * Cette fonction est le point d'entrée du micro-service Assesment
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

}
