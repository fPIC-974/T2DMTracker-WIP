package com.t2dmtracker.api.service;

import com.t2dmtracker.api.model.Patient;
import com.t2dmtracker.api.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
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
}