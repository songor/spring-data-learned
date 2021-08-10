package org.example.spring.data.dao;

import java.util.ArrayList;
import java.util.List;
import org.example.spring.data.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJdbcTemplateDAOImpl implements IStudentDAO {

  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Student> queryAll() {
    List<Student> students = new ArrayList<>();
    jdbcTemplate.query("select * from student", resultSet -> {
      Student student = new Student();
      student.setId(resultSet.getInt("id"));
      student.setName(resultSet.getString("name"));
      student.setAge(resultSet.getInt("age"));
      students.add(student);
    });
    return students;
  }

  @Override
  public void save(Student student) {
    jdbcTemplate.update("insert into student(name, age) values(?,?)",
        new Object[]{student.getName(), student.getAge()});
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
