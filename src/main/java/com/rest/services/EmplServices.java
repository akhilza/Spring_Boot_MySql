package com.rest.services;

import com.rest.dto.EmployeeDto;
import com.rest.dto.EmployeeRequestUpdate;
import com.rest.dto.EmployeeResponseEmail;
import com.rest.entity.Employee;

import java.util.List;

public interface EmplServices {
    Employee saveEmployee(EmployeeDto employeeDto);
    String saveEmployeeString(EmployeeDto employeeDto);
    List<Employee> listSaveEmployee(List<EmployeeDto> employeeDto);

    Employee getByEmployeeId(Long id);

    Employee getByEmployeeEmail(String email);

    List<Employee> getAll();

    Employee updateEmployee(Long id, EmployeeRequestUpdate requestUpdate);

    String deleteEmployee(Long id);
}
