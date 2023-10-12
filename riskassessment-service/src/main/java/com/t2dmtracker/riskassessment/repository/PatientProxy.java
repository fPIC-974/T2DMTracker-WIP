package com.t2dmtracker.riskassessment.repository;

import com.t2dmtracker.riskassessment.config.CustomProperties;
import com.t2dmtracker.riskassessment.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PatientProxy {

    private final Logger logger = LoggerFactory.getLogger(PatientProxy.class);

    private final CustomProperties customProperties;

    public PatientProxy(CustomProperties customProperties) {
        this.customProperties = customProperties;
    }

    public List<Patient> getPatients() {
        logger.debug("Calling getPatients()");

        String apiUrl = customProperties.getApiUrl();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Patient>> response = restTemplate.exchange(
                apiUrl + "/patients",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
    }

    public Patient getPatient(Integer id) {
        String apiUrl = customProperties.getApiUrl();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Patient> response = restTemplate.exchange(
                apiUrl + "/patient?id=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
    }
}
