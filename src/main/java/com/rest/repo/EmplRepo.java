package com.rest.repo;

import com.rest.dto.EmployeeResponseEmail;
import com.rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmplRepo extends JpaRepository<Employee,Long> {

        Optional<Employee> findByEmail(String email);

}
