package com.t2dmtracker.api.repository;

import com.t2dmtracker.api.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByLastNameAndFirstName(String lastName, String firstName);
}
