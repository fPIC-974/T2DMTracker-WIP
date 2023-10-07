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

    private final Logger logger = LoggerFactory.getLogger(PatientService.class);

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

    public Patient getPatient(Integer id) {
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

    public Patient updatePatient(Integer id, Patient patient) {
        logger.debug("Calling updatePatient(" + id + ", " + patient + ")");

        Patient toUpdate = patientProxy.updatePatient(id, patient);

        logger.debug("Updated Patient : " + toUpdate);

        return toUpdate;
    }

    public void deletePatient(Integer id) {
        logger.debug("Calling deletePatient(" + id + ")");

        patientProxy.deletePatient(id);

        logger.debug("Deleted Patient : " + id);
    }
}
