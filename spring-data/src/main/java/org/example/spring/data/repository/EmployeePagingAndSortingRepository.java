package org.example.spring.data.repository;

import org.example.spring.data.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository extends
    PagingAndSortingRepository<Employee, Integer> {

}
