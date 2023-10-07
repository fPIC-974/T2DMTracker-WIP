package com.t2dmtracker.webapp.controller;

import com.t2dmtracker.webapp.model.Note;
import com.t2dmtracker.webapp.model.Patient;
import com.t2dmtracker.webapp.service.NoteService;
import com.t2dmtracker.webapp.service.PatientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    Logger logger = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;
    private final NoteService noteService;

    public PatientController(PatientService patientService, NoteService noteService) {
        this.patientService = patientService;
        this.noteService = noteService;
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

    @GetMapping("/patient/details")
    public String getDetails(@RequestParam Integer id, Model model) {
        Patient patient = patientService.getPatient(id);
        List<Note> notes = noteService.getNotesByPatient(id);

        model.addAttribute("patient", patient);
        model.addAttribute("notes", notes);

        return "patient/details";
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

    @GetMapping("/patient/update")
    public String showUpdateForm(@RequestParam Integer id, Model model) {
        logger.debug("GET -- /patient/update - " + id);

        Patient patient = patientService.getPatient(id);

        model.addAttribute("patient", patient);

        return "patient/update";
    }

    @PostMapping("/patient/update")
    public String updateBid(@RequestParam Integer id, @Valid Patient patient,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "patient/update";
        }

        patientService.updatePatient(id, patient);
        model.addAttribute("patients", patientService.getPatients());

        return "redirect:/patient/list";
    }

    @GetMapping("/patient/delete")
    public String deletePatient(@RequestParam Integer id, Model model) {

        patientService.deletePatient(id);

        model.addAttribute("patients", patientService.getPatients());

        return "redirect:/patient/list";
    }
}
