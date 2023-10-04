package com.t2dmtracker.api;

import com.t2dmtracker.api.service.IPatientService;
import com.t2dmtracker.api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO - Disabling Spring Security for testing purposes
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private IPatientService patientService;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(patientService.getPatients());
	}
}
