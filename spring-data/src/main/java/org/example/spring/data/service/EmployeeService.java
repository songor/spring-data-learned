package org.example.spring.data.service;

import java.util.List;
import javax.transaction.Transactional;
import org.example.spring.data.domain.Employee;
import org.example.spring.data.repository.EmployeeCrudRepository;
import org.example.spring.data.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  private final EmployeeCrudRepository employeeCrudRepository;

  public EmployeeService(EmployeeRepository employeeRepository,
      EmployeeCrudRepository employeeCrudRepository) {
    this.employeeRepository = employeeRepository;
    this.employeeCrudRepository = employeeCrudRepository;
  }

  @Transactional
  public void updateAgeById(Integer id, Integer age) {
    employeeRepository.updateAgeById(id, age);
  }

  @Transactional
  public void save(List<Employee> employee) {
    employeeCrudRepository.saveAll(employee);
  }
}
