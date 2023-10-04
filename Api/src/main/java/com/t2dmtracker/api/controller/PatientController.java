package com.t2dmtracker.api.controller;

import com.t2dmtracker.api.model.Patient;
import com.t2dmtracker.api.service.IPatientService;
import com.t2dmtracker.api.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/patient")
    public Patient getPatient(@RequestParam String id) {
        return patientService.getPatientById(id);
    }
}
