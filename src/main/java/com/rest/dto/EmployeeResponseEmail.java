package com.rest.dto;

import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseEmail {
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;

}
