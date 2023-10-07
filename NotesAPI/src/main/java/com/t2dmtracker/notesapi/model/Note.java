package com.t2dmtracker.notesapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    private String id;

    @NotNull
    private String patientId;

    @NotNull
    private String note;
}
