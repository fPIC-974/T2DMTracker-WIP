package com.t2dmtracker.webapp.controller;

import com.t2dmtracker.webapp.model.Patient;
import com.t2dmtracker.webapp.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String home(Model model) {
        List<Patient> patientList = patientService.getPatients();

        model.addAttribute("patients", patientList);

        return "patients";
    }
}
