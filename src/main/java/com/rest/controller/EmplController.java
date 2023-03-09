package com.rest.controller;

import com.rest.dto.EmployeeDto;
import com.rest.dto.EmployeeRequestUpdate;
import com.rest.dto.EmployeeResponseEmail;
import com.rest.entity.Employee;
import com.rest.services.EmplServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EmplController {

    private final EmplServices services;

    public EmplController(EmplServices services) {
        this.services = services;
    }

    @PostMapping("employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(services.saveEmployee(employeeDto));
    }

    @PostMapping("employees/String")
    public ResponseEntity<String> saveEmployeeString(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(services.saveEmployeeString(employeeDto));
    }

    @PostMapping("listEmployees")
    public ResponseEntity<List<Employee>> saveEmployeeString(@RequestBody List<EmployeeDto> employeeDto) {
        return ResponseEntity.ok(services.listSaveEmployee(employeeDto));
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> findByEmployeeId(@PathVariable Long id) {
        return ResponseEntity.ok(services.getByEmployeeId(id));
    }

    @GetMapping("employees/email/{email}")
    public ResponseEntity<EmployeeResponseEmail> findByEmployeeEmail(@PathVariable String email) {
        Employee byEmployeeEmail1 = services.getByEmployeeEmail(email);
        EmployeeResponseEmail employeeResponseEmail = new EmployeeResponseEmail();
        employeeResponseEmail.setName(byEmployeeEmail1.getName());
        employeeResponseEmail.setLastName(byEmployeeEmail1.getLastName());
        employeeResponseEmail.setDateOfBirth(byEmployeeEmail1.getDateOfBirth());
        return ResponseEntity.ok(employeeResponseEmail);
    }

    @GetMapping("employees/all")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(services.getAll());
    }

    @PutMapping("employees/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestUpdate requestUpdate){
       return ResponseEntity.ok(services.updateEmployee(id, requestUpdate));
    }

    @DeleteMapping("employees/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(services.deleteEmployee(id));
    }


}
