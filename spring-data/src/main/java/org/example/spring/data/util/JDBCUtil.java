package org.example.spring.data.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

  public static Connection getConnection()
      throws ClassNotFoundException, SQLException, IOException {
    InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
    Properties properties = new Properties();
    properties.load(inputStream);

    Class.forName(properties.getProperty("jdbc.driver"));
    return DriverManager
        .getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.user"),
            properties.getProperty("jdbc.password"));
  }

  public static void release(Connection connection, Statement statement, ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
