package com.t2dmtracker.riskassessment;

import com.t2dmtracker.riskassessment.repository.NoteProxy;
import com.t2dmtracker.riskassessment.repository.PatientProxy;
import com.t2dmtracker.riskassessment.service.RiskAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO - Disabling Spring Security for testing purposes
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RequiredArgsConstructor
public class RiskassessmentServiceApplication implements CommandLineRunner {

	private final PatientProxy patientProxy;
	private final RiskAssessmentService riskAssessmentService;

	public static void main(String[] args) {
		SpringApplication.run(RiskassessmentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientProxy.getPatients().forEach(patient -> {
			riskAssessmentService.getTriggersByPatientId(patient.getId());
			riskAssessmentService.getRiskAssessmentByPatientId(patient.getId());
		});
	}
}
