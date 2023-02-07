package access_Arena;
import java.io.File;
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

public class T20 extends Match{
	
    public static void addmatches(){
        try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root", "12345");
      Statement stmt = con.createStatement();
         Scanner sc=new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\matches.csv"));
      String query="insert into t20_match values(?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(query);
      while(sc.hasNextLine())
      {
         String[] str=sc.nextLine().split(",");
         ps.setInt(1,Integer.parseInt(str[0]));
         ps.setString(2, str[1]);
         ps.setString(3, str[2]);
         ps.setString(4, str[3]);
         ps.executeUpdate();
      }
      }
      catch(Exception e){
          System.out.println(e);}
      }
    
	
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
           //LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
     
           
     
           
           
    
  
        //add match to ODI matches table with attributes teamA teamB matchid and date with match id as primary attribute
        String query = "insert into t20_match(TeamA,TeamB,Mdate) values('"+TeamA+"','"+TeamB+"','"+ date+"')";
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
        
        ResultSet rs = selection.getData("select * from t20_match");
    while(rs.next()){
       System.out.println(rs.getString(1)+ "  " + rs.getString(4)+ "   "  + rs.getString(2) + " " + "vs" + " "+ rs.getString(3));
    }
    System.out.println("Enter match id");
        match_id= sc.nextInt();
        String query = "delete from t20_match where Match_id = '"+match_id+"'";
         //insertion_updation_deletion.setData(query, "successfully deleted");
         Statement st = con.createStatement();
         st.executeUpdate(query);
         
        
    }
    public static void showmatches() throws SQLException{
       ResultSet rs = selection.getData("select * from t20_match");
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
            //LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
      
            String query = "update t20_match set MDate = '"+date+"'where match_id = '"+match_id+"' ";
                         // insertion_updation_deletion.setData(query, "successfully updated");
                         Statement st = con.createStatement();
         st.executeUpdate(query);
         System.out.printf("Match details updated succesfully of matchid=%s",match_id);
        
    }
 
        
    
    
    public static void main(String[] args) throws SQLException{
        //addmatches();
        Scanner sc=new Scanner(System.in);
         System.out.println("Enter 1 to add match\nEnter 2 to delete match\nEnter 3 to show match details");
         int choice=sc.nextInt();
         switch(choice) {
         case 1:
        	
        	 
                 try{
                     addmatch();}
                 catch(Exception e){
                     
                 }
                 break;
         case 2:
                 try{
        	 deletematch();
                 }
                 catch(Exception e){
                    
                 }
                 break;
                
         case 3:
        	 try{
             updatematch_date();}
                 catch(Exception e){
                     
                 }
        	 
         }
         
    }
}
/*class ODi extends Match{
	
    
	
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
     
           
     
           
           String query = "insert into odi_match(teamA,teamB,date) values('"+TeamA+"','"+TeamB+"','"+ date1+"')";
        //insertion_updation_deletion.setData(query, "successfully registered");
        Statement st = con.createStatement();
         st.executeUpdate(query);
  
        
        
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
    public static void showmatches() throws SQLException {
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
            //insertion_updation_deletion.setData(query, "successfully updated");
            Statement st = con.createStatement();
         st.executeUpdate(query);
        
    }
 
        
    
    
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
         System.out.println("Enter 1 to add match\nEnter 2 to delete match\nEnter 3 to show match details");
         int choice=sc.nextInt();
         switch(choice) {
         case 1:
        	
        	 addmatch();
                 try{
        	 showmatches();}
                 catch(Exception e){
                     
                 }
                 break;
         case 2:
                 try{
        	 deletematch();
                 showmatches();
                         }
                 catch(Exception e){
                     
                 }
                 break;
                 
         case 3:
             try{
        	 showmatches();}
             catch(Exception e){
                     
                 }
             break;
             
         case 4: 
             updatematch_date();
        	 
         }
          ResultSet rs = selection.getData("select * from t20_match");
    }
}*/