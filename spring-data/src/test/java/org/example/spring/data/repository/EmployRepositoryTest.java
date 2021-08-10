package org.example.spring.data.repository;

import static org.junit.Assert.assertNotNull;

import org.example.spring.data.domain.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployRepositoryTest {

  @Test
  public void testFindByName() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    Employee employee = repository.findByName("a");
    System.out.println(employee);
    assertNotNull(employee);
  }
}
