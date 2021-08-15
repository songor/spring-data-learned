package org.example.spring.data.repository;

import javax.persistence.criteria.Path;
import org.example.spring.data.domain.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeJpaSpecificationExecutorRepositoryTest {

  @Test
  public void testQuery() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeJpaSpecificationExecutorRepository repository = context
        .getBean(EmployeeJpaSpecificationExecutorRepository.class);

    Pageable pageable = PageRequest.of(0, 5, Sort.by(Order.desc("id")));
    Specification<Employee> specification = (root, criteriaQuery, criteriaBuilder) -> {
      Path<Integer> path = root.get("age");
      return criteriaBuilder.gt(path, 20);
    };
    Page<Employee> page = repository.findAll(specification, pageable);
    System.out.println("current page: " + page.getNumber());
    System.out.println("total page: " + page.getTotalPages());
    System.out.println("current page element size: " + page.getNumberOfElements());
    System.out.println("total element size: " + page.getTotalElements());
    System.out.println("current page elements: " + page.getContent());
  }
}