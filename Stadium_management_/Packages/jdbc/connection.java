/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

 import java.sql.Connection;
import java.sql.*;
/**
 *
 * i
 */
public class connection {
      public static Connection getCon()
      
      {
      try
      {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
          return con;
      }
      catch(Exception e)
              {
                  return null;   
              }
      }
}