package com.t2dmtracker.api.service;

import com.t2dmtracker.api.model.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> getPatients();

    Patient getPatientById(Integer id);

    Patient addPatient(Patient patient);

    Patient updatePatient(Integer id, Patient patient);

    void deletePatient(Integer id);
}
