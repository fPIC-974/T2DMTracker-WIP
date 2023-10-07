package com.t2dmtracker.api.service;

import com.t2dmtracker.api.model.Patient;
import com.t2dmtracker.api.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    private Logger logger = LoggerFactory.getLogger(PatientService.class);

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getPatients() {
        logger.debug("Calling getPatients()");

        List<Patient> patientList = patientRepository.findAll();

        logger.debug(patientList.toString());

        return patientList;
    }

    @Override
    public Patient getPatientById(Integer id) {
        logger.debug("Calling getPatient(" + id + ")");

        Optional<Patient> patient = patientRepository.findById(id);

        logger.debug(patient.toString());

        return patient.orElse(null);
    }

    @Override
    public Patient addPatient(Patient patient) {
        logger.debug("Calling addPatient(" + patient.toString() + ")");

        if (patientRepository.findByLastNameAndFirstName(patient.getLastName(), patient.getFirstName()).isPresent()) {
            logger.info("Patient already exists : " + patient);

            throw new InvalidParameterException("Patient already exists");
        }

        Patient toSave = patientRepository.save(patient);

        logger.debug("Added Patient : " + toSave);

        return toSave;
    }

    @Override
    public Patient updatePatient(Integer id, Patient patient) {
        logger.debug("Calling updatePatient(" + id + ", "+ patient);

        if (!patientRepository.existsById(id)) {
            logger.info("Patient not found -- ID : " + id);

            throw new InvalidParameterException("Patient not found");
        }

        patient.setId(id);

        Patient toUpdate = patientRepository.save(patient);

        logger.debug("Updated Patient : " + toUpdate);

        return toUpdate;
    }

    @Override
    public void deletePatient(Integer id) {
        logger.debug("Calling deletePatient(" + id + ")");

        if (!patientRepository.existsById(id)) {
            logger.info("Patient not found -- ID : " + id);

            throw new InvalidParameterException("Patient not found");
        }

        patientRepository.deleteById(id);

        logger.debug("Deleted Patient : " + id);
    }
}
