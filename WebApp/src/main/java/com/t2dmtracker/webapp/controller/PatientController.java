package com.t2dmtracker.webapp.controller;

import com.t2dmtracker.webapp.model.Patient;
import com.t2dmtracker.webapp.service.PatientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatientController {

    Logger logger = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return patientList(model);
    }

    @GetMapping("/patient/list")
    public String patientList(Model model) {
        logger.debug("GET -- /patient/list");

        List<Patient> patientList = patientService.getPatients();

        model.addAttribute("patients", patientList);

        return "patient/list";
    }

    @GetMapping("/patient/add")
    public String addPatient(Patient patient) {
        logger.debug("GET -- /patient/add : " + patient);

        return "patient/add";
    }

    @PostMapping("/patient/validate")
    public String validate(@Valid Patient patient, BindingResult result, Model model) {
        logger.debug("POST -- /patient/validate - " + patient);

        if (result.hasErrors()) {
            return "patient/add";
        }

        patientService.addPatient(patient);

        model.addAttribute("patients", patientService.getPatients());

        return "redirect:/patient/list";
    }
}
