package com.example;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String USER = "root";
    private static final String PASSWORD = "MyNewPassword@123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection to the Database!");
          insertStudent(conn, "Nandu", "nandu@gmail.com");
            // updatestudent(conn,1, "Ankit","Ankit@gmail.com");
        //    updatestudent(conn,2, "Nandu", "nandu@gmail.com");
            selectStudents(conn);
         //   deleteStudent(conn, 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, String name, String email) {
        String sql = "Insert into Student (name, email) VALUES (' " + name + "','" + email + "')";
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("INSERTED:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

private static void selectStudents(Connection conn) {
    String sql = "SELECT*FROM STUDENT";
    try(Statement stmt = conn.createStatement()) {
        ResultSet resultSet = stmt.executeQuery(sql);
        System.out.println("Students List :");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println(id+ ":"+name+":"+email);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

private static void updatestudent(Connection conn, int id, String name, String email) {
  String sql= "UPDATE Student SET name ='"+name+"',email= '"+email+"'Where id ="+id;
    try (Statement stmt = conn.createStatement()) {
        int rows = stmt.executeUpdate(sql);
        System.out.println("UPDATED:" + rows);
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
  private static void deleteStudent(Connection conn, int id) {
      String sql = "DELETE FROM student WHERE id = " +id;
      try (Statement stmt = conn.createStatement()) {
          int rows = stmt.executeUpdate(sql);
          System.out.println("DELETED:" + rows);
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
}

/**      Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the Database!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                System.out.println("Connection Closed!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
**/
