package org.example.spring.data.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeServiceTest {

  @Test
  public void testUpdateAgeById() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeService service = context.getBean(EmployeeService.class);
    service.updateAgeById(1, 25);
  }
}