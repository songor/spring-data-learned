package org.example.spring.data.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.example.spring.data.domain.Employee;
import org.junit.Ignore;
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

  @Test
  public void testFindByNameStartingWithAndAgeLessThan() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    List<Employee> employee = repository.findByNameStartingWithAndAgeLessThan("a", 30);
    for (Employee e : employee) {
      System.out.println(e);
    }
    assertNotNull(employee);
  }

  @Test
  public void testFindByNameInOrAgeLessThan() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    List<Employee> employee = repository.findByNameInOrAgeLessThan(Arrays.asList("a", "b"), 30);
    for (Employee e : employee) {
      System.out.println(e);
    }
    assertNotNull(employee);
  }

  @Test
  public void testGetLatestEmployee() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    Employee employee = repository.getLatestEmployee();
    System.out.println(employee);
    assertNotNull(employee);
  }

  @Test
  public void testGetEmployeeByIndex() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    List<Employee> employee = repository.getEmployeeByIndex("a", 18);
    for (Employee e : employee) {
      System.out.println(e);
    }
    assertNotNull(employee);
  }

  @Test
  public void testGetEmployeeByParam() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    List<Employee> employee = repository.getEmployeeByParam("a", 18);
    for (Employee e : employee) {
      System.out.println(e);
    }
    assertNotNull(employee);
  }

  @Test
  public void testGetEmployeeByIndexNameFuzzy() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    List<Employee> employee = repository.getEmployeeByIndexNameFuzzy("a");
    for (Employee e : employee) {
      System.out.println(e);
    }
    assertNotNull(employee);
  }

  @Test
  public void testGetEmployeeByParamNameFuzzy() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    List<Employee> employee = repository.getEmployeeByParamNameFuzzy("a");
    for (Employee e : employee) {
      System.out.println(e);
    }
    assertNotNull(employee);
  }

  @Test
  public void testCount() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    Long count = repository.count();
    System.out.println("count: " + count);
    assertNotNull(count);
  }

  @Ignore
  @Test
  public void testUpdateAgeById() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
    EmployeeRepository repository = context.getBean(EmployeeRepository.class);
    repository.updateAgeById(1, 20);
  }
}
