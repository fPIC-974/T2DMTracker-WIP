package com.t2dmtracker.api.service;

import com.t2dmtracker.api.model.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> getPatients();

    Patient getPatientById(String id);

    Patient addPatient(Patient patient);

    Patient updatePatient(String id, Patient patient);
}
