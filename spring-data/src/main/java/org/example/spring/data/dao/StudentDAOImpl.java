package org.example.spring.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.example.spring.data.domain.Student;
import org.example.spring.data.util.JDBCUtil;

public class StudentDAOImpl implements IStudentDAO {

  @Override
  public List<Student> queryAll() {
    List<Student> students = new ArrayList<>();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = JDBCUtil.getConnection();
      preparedStatement = connection.prepareStatement("select * from student");
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Integer age = resultSet.getInt("age");
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        students.add(student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtil.release(connection, preparedStatement, resultSet);
    }

    return students;
  }

  @Override
  public void save(Student student) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = JDBCUtil.getConnection();
      preparedStatement = connection.prepareStatement("insert into student(name, age) values(?,?)");
      preparedStatement.setString(1, student.getName());
      preparedStatement.setInt(2, student.getAge());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtil.release(connection, preparedStatement, resultSet);
    }
  }
}
