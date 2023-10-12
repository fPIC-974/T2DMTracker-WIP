package com.t2dmtracker.riskassessment.service;

import com.t2dmtracker.riskassessment.model.Note;
import com.t2dmtracker.riskassessment.model.Patient;
import com.t2dmtracker.riskassessment.model.RiskAssessment;
import com.t2dmtracker.riskassessment.repository.NoteProxy;
import com.t2dmtracker.riskassessment.repository.PatientProxy;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class RiskAssessmentService {

    private final NoteProxy noteProxy;

    private final PatientProxy patientProxy;

    List<String> triggerValues = Arrays.asList(
            "Hémoglobine A1C",
            "Microalbumine",
            "Taille",
            "Poids",
            "Fume",
            "Anormal",
            "Cholestérol",
            "Vertiges",
            "Rechute",
            "Réaction",
            "Anticorps");

    public List<String> getTriggersByPatientId(Integer id) {
        List<String> triggerList = new ArrayList<>();

        List<Note> notes = noteProxy.getNotesByPatient(id);

        notes.forEach(note -> {
            triggerValues.forEach(trigger -> {
                if (trigger.equals("Poids")) {
                    Pattern pattern = Pattern.compile("Poids.*inf.*recommand");
                    Matcher matcher = pattern.matcher(note.getNote());

                    if (findTriggerInNote(trigger, note)) {
                        if (!matcher.find()) {
                            triggerList.add(trigger);
                        }
                    }
                } else {
                    if (findTriggerInNote(trigger, note)) {
                        triggerList.add(trigger);
                    }
                }
            });
        });

        log.debug(id + ":" + triggerList.toString());

        return triggerList;
    }

    public boolean findTriggerInNote(String trigger, Note note) {
        return StringUtils.containsIgnoreCase(note.getNote(), trigger);
    }

    public String getRiskAssessmentByPatientId(Integer id) {
        Patient patient = patientProxy.getPatient(id);
        RiskAssessment riskAssessment = RiskAssessment.builder()
                .age(LocalDate.now().compareTo(patient.getBirthDate()))
                .gender(patient.getGender())
                .risks(getTriggersByPatientId(id))
                .build();


        if (riskAssessment.isEarlyOnSet()) {
            log.debug(id + ": EarlyOnSet");
            return "EarlyOnSet";
        }

        if (riskAssessment.isBorderLine()) {
            log.debug(id + ": BorderLine");
            return "BorderLine";
        }

        if (riskAssessment.isDanger()) {
            log.debug(id + ": Danger");
            return "Danger";
        }

        if (riskAssessment.isNone()) {
            log.debug(id + ": None");
            return "None";
        }

        return null;
    }
}
