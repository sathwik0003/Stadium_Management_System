/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 *  
 */
public class tables {
    public static void main(String[] args){
        Connection con = null;
        Statement st = null;
        try{
            con=connection.getCon();
            st = con.createStatement();
     //     st.executeUpdate("create table login(username varchar(50),password varchar(20),flag varchar(20))");
        //st.executeUpdate("create table user(user_id int not null auto_increment primary key,email varchar(30),phone_no long, gender varchar(2), age int, username varchar(50) ,password varchar(20),status varchar(20))");
         //st.executeUpdate("create table stadium(matchid int,matchname varchar(40),price varchar(20))");
        //  String se = "IND VS AUS";
       //     st.executeUpdate("insert into stadium values(1,'"+se+"',100)");
        //st.executeUpdate("create table cleaner(employee_id  varchar(50) not null primary key,employee_name varchar(20),phone_no long, salary int, tier int)");
      //st.executeUpdate("create table cooking_department(employee_id  varchar(50) not null primary key ,employee_name varchar(20),phone_no long, salary int, tier int)");  
      //st.executeUpdate("create table security(employee_id  varchar(50) not null primary key ,employee_name varchar(20),phone_no long, salary int, tier int)");
      //st.executeUpdate("create table event_manager(employee_id  varchar(50) not null primary key ,employee_name varchar(20),phone_no long, salary int, tier int)");
      //st.executeUpdate("create table t20_match(match_id int not null auto_increment primary key,teamA varchar(30),teamB varchar(30), date date)");
      //st.executeUpdate("create table odi_match(match_id int not null auto_increment primary key,teamA varchar(30),teamB varchar(30), date date)");
           JOptionPane.showMessageDialog(null,"table created happily");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog( null, e);
        }
        finally{
            try{
            con.close();
            st.close();
        }
        catch(Exception e){
            
        }
        }
    }
    
}