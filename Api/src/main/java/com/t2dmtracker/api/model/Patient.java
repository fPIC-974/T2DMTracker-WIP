package com.t2dmtracker.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
