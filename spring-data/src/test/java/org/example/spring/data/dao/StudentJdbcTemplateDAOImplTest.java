package org.example.spring.data.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.example.spring.data.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentJdbcTemplateDAOImplTest {

  private ApplicationContext context;

  @Before
  public void init() {
    context = new ClassPathXmlApplicationContext("beans.xml");
  }

  @Test
  public void testQueryAll() {
    IStudentDAO studentDAO = (IStudentDAO) context.getBean("studentDAO");
    List<Student> students = studentDAO.queryAll();
    for (Student student : students) {
      System.out.println(student);
    }
    assertNotNull(students);
  }

  @Test
  public void testSave() {
    Student student = new Student();
    student.setName("f");
    student.setAge(38);

    IStudentDAO studentDAO = (IStudentDAO) context.getBean("studentDAO");
    studentDAO.save(student);
  }
}
