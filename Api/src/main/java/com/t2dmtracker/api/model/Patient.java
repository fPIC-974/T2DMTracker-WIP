package com.t2dmtracker.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "patients")
@Data
public class Patient {

    @Id
    private String id;

    private String lastName;

    private String firstName;

    private LocalDate birthdate;

    private Character gender;

    private String address;

    private String phone;
}
