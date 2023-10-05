package com.t2dmtracker.webapp.service;

import com.t2dmtracker.webapp.model.Patient;
import com.t2dmtracker.webapp.repository.PatientProxy;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class PatientService {

    private Logger logger = LoggerFactory.getLogger(PatientService.class);

    private final PatientProxy patientProxy;

    public PatientService(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    public List<Patient> getPatients() {
        logger.debug("Calling getPatients()");

        List<Patient> patientList = patientProxy.getPatients();

        logger.debug(patientList.toString());

        return patientList;
    }

    public Patient getPatient(String id) {
        logger.debug("Calling getPatient(" + id + ")");

        Patient patient = patientProxy.getPatient(id);

        logger.debug(patient.toString());

        return patientProxy.getPatient(id);
    }

    public Patient addPatient(Patient patient) {
        logger.debug("Calling addPatient(" + patient + ")");

        Patient toSave = patientProxy.addPatient(patient);

        logger.debug("Added Patient : " + toSave);

        return toSave;
    }
}
