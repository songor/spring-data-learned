package org.example.spring.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.example.spring.data.domain.Employee;
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

  @Test
  public void testSave() {
    List<Employee> employee = new ArrayList<>();
    IntStream.range(0, 10).forEach(i -> {
      Employee e = new Employee();
      e.setName("em" + i);
      e.setAge(i + 10);
      employee.add(e);
    });

    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeService service = context.getBean(EmployeeService.class);
    service.save(employee);
  }
}