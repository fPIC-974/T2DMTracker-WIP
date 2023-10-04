package com.t2dmtracker.webapp.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Patient {
    private String id;

    private String lastName;

    private String firstName;

    private LocalDate birthdate;

    private Character gender;

    private String address;

    private String phone;
}
