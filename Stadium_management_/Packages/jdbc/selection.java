/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 */
public class selection {
    public static ResultSet getData(String Query)
    {
        Connection con = null;
        ResultSet rs = null;
       Statement st = null;
       try{
         con = connection.getCon();
         st =  con.createStatement();
         rs = st.executeQuery(Query);
         return rs;
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
           return null;
       }
    }
}