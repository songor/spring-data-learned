package org.example.spring.data.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.example.spring.data.domain.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeJpaRepositoryTest {

  @Test
  public void testFindOne() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeJpaRepository repository = context.getBean(EmployeeJpaRepository.class);

    assertFalse(repository.existsById(15));
    List<Employee> employee = repository.findAll();
    System.out.println(employee);
    assertNotNull(employee);
  }
}