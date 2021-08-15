package org.example.spring.data.repository;

import org.example.spring.data.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}
