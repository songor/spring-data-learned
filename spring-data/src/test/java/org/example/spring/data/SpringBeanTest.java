package org.example.spring.data;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringBeanTest {

  private ApplicationContext context;

  @Before
  public void init() {
    context = new ClassPathXmlApplicationContext("beans.xml");
  }

  @Test
  public void testDataSource() {
    DataSource dataSource = (DataSource) context.getBean("dataSource");
    assertNotNull(dataSource);
  }

  @Test
  public void testJdbcTemplate() {
    JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    assertNotNull(jdbcTemplate);
  }
}
