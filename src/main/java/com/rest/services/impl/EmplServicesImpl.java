package com.rest.services.impl;

import com.rest.dto.EmployeeDto;
import com.rest.dto.EmployeeRequestUpdate;
import com.rest.entity.Employee;
import com.rest.repo.EmplRepo;
import com.rest.services.EmplServices;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmplServicesImpl implements EmplServices {

    private final EmplRepo emplRepo;

    public EmplServicesImpl(EmplRepo emplRepo) {
        this.emplRepo = emplRepo;
    }

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        return emplRepo.save(entityTODto(employeeDto));
    }

    @Override
    public String saveEmployeeString(EmployeeDto employeeDto) {
        emplRepo.save(entityTODto(employeeDto));
        return "Saved";
    }

    @Override
    public List<Employee> listSaveEmployee(List<EmployeeDto> employeeDto) {
        return emplRepo.saveAll(listEntityTODto(employeeDto));
    }

    @Override
    public Employee getByEmployeeId(Long id) {
        return emplRepo.findById(id).orElse(null);
    }

    @Override
    public Employee getByEmployeeEmail(String email) {
        return emplRepo.findByEmail(email).orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return emplRepo.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeRequestUpdate requestUpdate) {
        Employee employee = emplRepo.findById(id).orElse(null);
        if(Objects.nonNull(employee)){
            employee.setName(requestUpdate.getName());
            employee.setLastName(requestUpdate.getLastName());
            employee.setEmail(requestUpdate.getEmail());
            employee.setPassword(requestUpdate.getEmail());
            return emplRepo.save(employee);
        }else{
            return null;
        }
    }

    @Override
    public String deleteEmployee(Long id) {
        emplRepo.deleteById(id);
        return "Data Successfully Delete";
    }


    private Employee entityTODto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }


    private List<Employee> listEntityTODto(List<EmployeeDto> employeeDto) {
        List<Employee> employee = new ArrayList<>();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }
}
