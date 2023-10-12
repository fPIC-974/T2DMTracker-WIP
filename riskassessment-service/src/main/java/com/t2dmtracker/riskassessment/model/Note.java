package com.t2dmtracker.riskassessment.model;

import lombok.Data;

@Data
public class Note {
    private String id;

    private Integer patientId;

    private String note;

    @Override
    public String toString() {
        return this.note.replaceAll("\r\n", "<BR>");
    }
}
