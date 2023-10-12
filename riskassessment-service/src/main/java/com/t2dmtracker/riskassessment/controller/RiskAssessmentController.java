package com.t2dmtracker.riskassessment.controller;

import com.t2dmtracker.riskassessment.service.RiskAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RiskAssessmentController {

    private final RiskAssessmentService riskAssessmentService;

    @GetMapping("/assessment")
    public String getRiskAssessmentByPatientId(@RequestParam Integer id) {
        return riskAssessmentService.getRiskAssessmentByPatientId(id);
    }
}
