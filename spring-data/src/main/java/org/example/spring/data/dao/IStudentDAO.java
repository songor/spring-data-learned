package org.example.spring.data.dao;

import java.util.List;
import org.example.spring.data.domain.Student;

public interface IStudentDAO {

  List<Student> queryAll();

  void save(Student student);
}
