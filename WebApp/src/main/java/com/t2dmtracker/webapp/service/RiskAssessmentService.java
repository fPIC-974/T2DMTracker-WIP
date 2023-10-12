package com.t2dmtracker.webapp.service;

import com.t2dmtracker.webapp.repository.RiskAssessmentProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiskAssessmentService {
    private final RiskAssessmentProxy riskAssessmentProxy;

    public String getRiskAssessmentByPatientId(Integer id) {
        return riskAssessmentProxy.getRiskAssessmentByPatientId(id);
    }
}
