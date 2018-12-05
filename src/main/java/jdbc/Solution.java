package jdbc;

import java.sql.*;

public class Solution {

  public static void main (String[] args) throws SQLException {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:postgresql://k8s-jtc.vtb-dbo.projects.epam.com:32405/ib", "postgres", "admin"); // 1. Установка соединения
      if (conn == null) {
        System.out.println("Нет соединения с БД!");
        System.exit(0);
      }
      Statement stmt = conn.createStatement(); // 3. Создание объекта для передачи запросов
      ResultSet rs = stmt.executeQuery("SELECT t.* FROM rrko.rrko_ru_payment t"); // 4. Выполнение запроса
      while (rs.next()) { // 5. Обработка результатов выполнения запроса
        System.out.println(rs.getRow() + ". | " + " id = " + rs.getString("id") + "| Client_ext_id =" + "\t" + rs.getString("client_ext_id"));
      }
       /* При закрытии Statement автоматически закрываются все связанные с ним открытые объекты ResultSet*/
      stmt.close();  // 6. Закрытие соединения (закрывает так же и ResultSet)
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      conn.close();
    }
  }
}