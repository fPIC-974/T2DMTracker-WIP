package com.t2dmtracker.webapp.repository;

import com.t2dmtracker.webapp.config.CustomProperties;
import com.t2dmtracker.webapp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PatientProxy {

    private final CustomProperties customProperties;

    public PatientProxy(CustomProperties customProperties) {
        this.customProperties = customProperties;
    }

    public List<Patient> getPatients() {
        String apiUrl = customProperties.getApiUrl();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Patient>> response = restTemplate.exchange(
                apiUrl + "/patients",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Patient>>() {
                }
        );

        return response.getBody();
    }

    public Patient getPatient(String id) {
        String apiUrl = customProperties.getApiUrl();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Patient> response = restTemplate.exchange(
                apiUrl + "/patient?id=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Patient>() {
                }
        );

        return response.getBody();
    }
}
