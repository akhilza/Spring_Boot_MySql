package com.rest.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseEmail {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    private LocalDate dateOfBirth;

}
