package org.example.spring.data.service;

import javax.transaction.Transactional;
import org.example.spring.data.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Transactional
  public void updateAgeById(Integer id, Integer age) {
    employeeRepository.updateAgeById(id, age);
  }
}
