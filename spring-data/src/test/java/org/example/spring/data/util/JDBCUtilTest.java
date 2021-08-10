package org.example.spring.data.util;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class JDBCUtilTest {

  @Test
  public void testGetConnection() throws SQLException, ClassNotFoundException, IOException {
    Connection connection = JDBCUtil.getConnection();
    assertNotNull(connection);
  }

}
