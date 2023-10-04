package com.t2dmtracker.api.repository;

import com.t2dmtracker.api.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findByLastNameAndFirstName(String lastName, String firstName);
}
