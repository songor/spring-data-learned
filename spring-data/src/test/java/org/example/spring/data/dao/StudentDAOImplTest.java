package org.example.spring.data.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.example.spring.data.domain.Student;
import org.junit.Test;

public class StudentDAOImplTest {

  @Test
  public void testQueryAll() {
    IStudentDAO dao = new StudentDAOImpl();
    List<Student> students = dao.queryAll();
    for (Student student : students) {
      System.out.println(student);
    }
    assertNotNull(students);
  }

  @Test
  public void testSave() {
    Student student = new Student();
    student.setName("e");
    student.setAge(35);

    IStudentDAO dao = new StudentDAOImpl();
    dao.save(student);
  }

}
