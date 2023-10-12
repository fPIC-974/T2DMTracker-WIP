package com.t2dmtracker.riskassessment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="com.t2dmtracker.riskassessment")
public class CustomProperties {
    private String apiUrl;

    private String notesApiUrl;
}
