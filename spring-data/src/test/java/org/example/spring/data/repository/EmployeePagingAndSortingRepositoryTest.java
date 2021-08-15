package org.example.spring.data.repository;

import org.example.spring.data.domain.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public class EmployeePagingAndSortingRepositoryTest {

  @Test
  public void testPage() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeePagingAndSortingRepository repository = context
        .getBean(EmployeePagingAndSortingRepository.class);

    Pageable pageable = PageRequest.of(0, 5);
    Page<Employee> page = repository.findAll(pageable);
    System.out.println("current page: " + page.getNumber());
    System.out.println("total page: " + page.getTotalPages());
    System.out.println("current page element size: " + page.getNumberOfElements());
    System.out.println("total element size: " + page.getTotalElements());
    System.out.println("current page elements: " + page.getContent());
  }

  @Test
  public void testSort() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeePagingAndSortingRepository repository = context
        .getBean(EmployeePagingAndSortingRepository.class);

    Pageable pageable = PageRequest.of(0, 5, Sort.by(Order.desc("id")));
    Page<Employee> page = repository.findAll(pageable);
    System.out.println("current page elements: " + page.getContent());
  }
}