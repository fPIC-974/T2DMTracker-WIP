package com.t2dmtracker.webapp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Data
public class Patient {
    private Integer id;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotNull(message = "Birth Date is mandatory")
    private LocalDate birthDate;

    @NotNull(message = "Gender is mandatory")
    private Character gender;

    private String address;

    private String phone;
}
