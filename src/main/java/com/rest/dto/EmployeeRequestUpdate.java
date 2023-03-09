package com.rest.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequestUpdate {

    private String name;
    private String lastName;
    private String email;
    private String password;
}
