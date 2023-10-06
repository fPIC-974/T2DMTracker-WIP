package com.t2dmtracker.webapp.model;

import lombok.Data;

@Data
public class Note {
    private String id;

    private String patientId;

    private String note;
}
