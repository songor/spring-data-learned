package org.example.spring.data.repository;

import org.example.spring.data.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
