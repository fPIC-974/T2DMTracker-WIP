package com.t2dmtracker.api.service;

import com.t2dmtracker.api.model.Patient;
import com.t2dmtracker.api.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.parameters.P;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    public void shouldGetAllUsers() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient());
        patients.add(new Patient());

        when(patientRepository.findAll()).thenReturn(patients);

        List<Patient> toCheck = patientService.getPatients();

        assertEquals(2, toCheck.size());
    }

    @Test
    public void shouldNotGetAllUsers() {
        when(patientRepository.findAll()).thenReturn(new ArrayList<>());

        List<Patient> toCheck = patientService.getPatients();

        assertTrue(toCheck.isEmpty());
    }

    @Test
    public void shouldGetPatientById() {
        Patient patient = new Patient("idea", "Doe", "John", LocalDate.of(2222, 12, 2), 'M', "221B BakerStreet", "000-0000-0000");
        when(patientRepository.findById(anyString())).thenReturn(Optional.of(patient));

        Patient toCheck = patientService.getPatientById("idea");

        assertNotNull(toCheck);
        assertEquals("idea", toCheck.getId());
    }

    @Test
    public void shouldNotGetPatientByIncorrectId() {
        when(patientRepository.findById(anyString())).thenReturn(Optional.empty());

        Patient toCheck = patientService.getPatientById("idea");

        assertNull(toCheck);
    }

    @Test
    public void shouldAddPatient() {
        Patient patient = new Patient(null, "Doe", "John", LocalDate.now(), 'M', "221B Baker St", "000-0000-00000");

        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        Patient toCheck = patientService.addPatient(patient);

        assertNotNull(patient);
        assertEquals("Doe", toCheck.getLastName());
        assertEquals("John", toCheck.getFirstName());
    }

    @Test
    public void shouldNotAddExistingPatient() {
        Patient patient = new Patient(null, "Doe", "John", LocalDate.now(), 'M', "221B Baker St", "000-0000-00000");

        when(patientRepository.findByLastNameAndFirstName(anyString(), anyString())).thenReturn(Optional.of(patient));

        InvalidParameterException invalidParameterException = assertThrows(InvalidParameterException.class,
                () -> patientService.addPatient(patient));

        assertTrue(invalidParameterException.getMessage().contains("Patient already exists"));
    }

    @Test
    public void shouldUpdatePatient() {
        Patient patient = new Patient("idea", "Doe", "John", LocalDate.now(), 'M', "221B Baker St", "000-0000-00000");
        Patient update = new Patient("idea", "Doe", "Jane", LocalDate.now(), 'M', "221B Baker St", "000-0000-00000");

        when(patientRepository.existsById(anyString())).thenReturn(true);
        when(patientRepository.save(any(Patient.class))).thenReturn(update);

        Patient toCheck = patientService.updatePatient("idea", update);

        assertEquals(patient.getId(), toCheck.getId());
        assertEquals(patient.getLastName(), toCheck.getLastName());
        assertNotEquals(patient.getFirstName(), toCheck.getFirstName());
    }

    @Test
    public void shouldNotUpdateMissingPatient() {
        Patient update = new Patient("idea", "Doe", "Jane", LocalDate.now(), 'M', "221B Baker St", "000-0000-00000");

        when(patientRepository.existsById(anyString())).thenReturn(false);

        InvalidParameterException invalidParameterException = assertThrows(InvalidParameterException.class,
                () -> patientService.updatePatient("idea", update));

        assertTrue(invalidParameterException.getMessage().contains("Patient not found"));
    }

    @Test
    public void shouldDeletePatient() {
        when(patientRepository.existsById(anyString())).thenReturn(true);

        patientService.deletePatient("idea");

        assertDoesNotThrow(() -> {});
    }

    @Test
    public void shouldNotDeleteMissingPatient() {
        when(patientRepository.existsById(anyString())).thenReturn(false);

        InvalidParameterException invalidParameterException = assertThrows(InvalidParameterException.class,
                () -> patientService.deletePatient("idea"));

        assertTrue(invalidParameterException.getMessage().contains("Patient not found"));
    }
}