package org.example.spring.data.repository;

import java.util.List;
import org.example.spring.data.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends Repository<Employee, Integer> {

  Employee findByName(String name);

  List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

  List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

  @Query("select e from Employee e where e.id = (select max(id) from Employee)")
  Employee getLatestEmployee();

  @Query("select e from Employee e where e.name=?1 and e.age=?2")
  List<Employee> getEmployeeByIndex(String name, Integer age);

  @Query("select e from Employee e where e.name=:name and e.age=:age")
  List<Employee> getEmployeeByParam(@Param("name") String name, @Param("age") Integer age);

  @Query("select e from Employee e where e.name like %?1%")
  List<Employee> getEmployeeByIndexNameFuzzy(String name);

  @Query("select e from Employee e where e.name like %:name%")
  List<Employee> getEmployeeByParamNameFuzzy(@Param("name") String name);

  @Query(nativeQuery = true, value = "select count(1) from employee")
  Long count();
}
