package org.example.spring.data;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringBeanTest {

  @Test
  public void testDataSource() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    DataSource dataSource = (DataSource) context.getBean("dataSource");
    assertNotNull(dataSource);
  }

  @Test
  public void testJdbcTemplate() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    assertNotNull(jdbcTemplate);
  }

  @Test
  public void testEntityManagerFactory() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
  }
}
