/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package access_Arena;
import jdbc.*;
import java.sql.*;

import java.util.Scanner;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
 



abstract class Match{
    protected static int match_id;
    protected static String date;
    protected static String TeamA;
    protected static String TeamB;
    
    
}

public class ODi extends Match{
	
    
	
    public static void addmatch() throws Exception{
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
    	Scanner sc=new Scanner(System.in);
        System.out.println("Enter Team A");
        TeamA= sc.next();
        System.out.println("Enter Team B");
        TeamB= sc.next();
       
       
           // String is of the format y-M-d or yyyy-MM-d
    	   System.out.println("Enter match date");
           String date = sc.next();
     
           //Using parse method to convert the string to LocalDate object
           LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
     
           
     
           
           
    
  
        //add match to ODI matches table with attributes teamA teamB matchid and date with match id as primary attribute
        String query = "insert into odi_match(teamA,teamB,date) values('"+TeamA+"','"+TeamB+"','"+ date1+"')";
        //System.out.println("ADDED");
        //insertion_updation_deletion.setData(query, "successfully registered");
        Statement st = con.createStatement();
         st.executeUpdate(query);
        //System.out.println("inserted");
           
    }
    public static void deletematch() throws Exception{
       Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        Scanner sc=new Scanner(System.in);
        
        ResultSet rs = selection.getData("select * from odi_match");
    while(rs.next()){
       System.out.println(rs.getString(1)+ "  " + rs.getString(4)+ "   "  + rs.getString(2) + " " + "vs" + " "+ rs.getString(3));
    }
    System.out.println("Enter match id");
        match_id= sc.nextInt();
        String query = "delete from odi_match where match_id = '"+match_id+"'";
         //insertion_updation_deletion.setData(query, "successfully deleted");
         Statement st = con.createStatement();
         st.executeUpdate(query);
         
        
    }
    public static void showmatches() throws SQLException{
       ResultSet rs = selection.getData("select * from odi_match");
    while(rs.next()){
       System.out.println(rs.getString(1)+ "  " + rs.getString(4)+ "   "  + rs.getString(2) + " " + "vs" + " "+ rs.getString(3));
    }
    }
    public static void updatematch_date() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
    	Scanner sc=new Scanner(System.in);
    	DateTimeFormatter format=null;
        System.out.println("Enter the match id for which you want to update date");
        int id=sc.nextInt();
       
            // String is of the format y-M-d or yyyy-MM-d
     	   System.out.println("Enter match date");
            String date = sc.next();
      
            //Using parse method to convert the string to LocalDate object
            LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
      
            String query = "update odi_match set date = '"+date+"'where match_id = '"+match_id+"' ";
                         // insertion_updation_deletion.setData(query, "successfully updated");
                         Statement st = con.createStatement();
         st.executeUpdate(query);
        
    }
 
        
    
    
    public static void main(String[] args) throws SQLException{
        Scanner sc=new Scanner(System.in);
         System.out.println("Enter 1 to add match\nEnter 2 to delete match\nEnter 3 to show match details");
         int choice=sc.nextInt();
         switch(choice) {
         case 1:
        	
        	 
                 try{
                     addmatch();
        	 showmatches();}
                 catch(Exception e){
                     
                 }
         case 2:
                 try{
        	 deletematch();
                 }
                 catch(Exception e){
                    
                 }
                
         case 3:
        	 try{
             showmatches();}
                 catch(Exception e){
                     
                 }
        	 
         }
         
    }
}
