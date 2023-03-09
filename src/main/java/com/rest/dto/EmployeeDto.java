package com.rest.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
}
