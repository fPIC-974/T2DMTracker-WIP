package com.t2dmtracker.webapp.repository;

import com.t2dmtracker.webapp.config.CustomProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RiskAssessmentProxy {
    private final CustomProperties customProperties;

    public String getRiskAssessmentByPatientId(Integer id) {
        String riskassessmentApiUrl = customProperties.getRiskassessmentApiUrl();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(
                riskassessmentApiUrl + "/assessment?id=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );

        return response.getBody();
    }
}
