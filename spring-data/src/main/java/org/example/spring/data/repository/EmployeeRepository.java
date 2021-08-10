package org.example.spring.data.repository;

import org.example.spring.data.domain.Employee;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends Repository<Employee, Integer> {

  Employee findByName(String name);
}
