package com.company;

import java.sql.*;  

public class Database {
  private static Connection connection;

  public static void initializeConnection(){
    //setup connection
    try {
      Class.forName("com.mysql.jdbc.Driver");  
      connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "Start1234%");
    }catch(Exception e){
      System.out.println(e);
    }  
  }

  public static ResultSet runQuery(String query){
    try {
      Statement statement = connection.createStatement();
      ResultSet result = statement.executeQuery(query);
      return result;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public static void closeConnection(){
    try {
      connection.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
