package access_Arena;
import java.util.*;
import java.sql.*;

public class Booking_status extends Booking {
    public static void searchviaid(){
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        System.out.println("Enter Id to search");
        userid = input.nextInt();
        
         Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from booking_status where userid ='"+userid+"'");
        
        while(rs.next()){
            System.out.println(rs.getInt(1) +"   " + rs.getString(2)+ "   " + rs.getString(3)+ " vs "  + rs.getString(4) + "  " + rs.getString(5)+ "  " +rs.getString(6));
        }
        
        }
        catch(Exception e) {
         System.out.println(e);
                 }
    }
    
    public static void searchvianame(){
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        
        System.out.println("Enter username to search");
        Username = input.nextLine();
        
         Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from booking_status where username like '%"+Username+"%'");
       
        while(rs.next()){
            System.out.println(rs.getInt(1) +"  " + rs.getString(2)+ "  " + rs.getString(3)+ " vs "  + rs.getString(4) + "  " + rs.getString(5)+ "  " +rs.getString(6));
        }
        }
      catch(Exception e) {
         System.out.println(e);
                 }  
        
    }
    
    public static void searchviastandno(){
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        
        System.out.println("Enter Stand No to search");
        Stand_no = input.nextInt();
        
         Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from booking_status where StandNo = '"+Stand_no+"'");
        
        while(rs.next()){
            System.out.println(rs.getInt(1) +"  " + rs.getString(2)+ " " + rs.getString(3)+ " vs "  + rs.getString(4) + "  " + rs.getString(5)+ "  " +rs.getString(6));
        }
        }
      catch(Exception e) {
         System.out.println(e);
                 }  
        
    }
    
    public static void printdetails(){
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from booking_status");
        
        while(rs.next()){
            
            System.out.println(rs.getInt(1) +"  " + rs.getString(2)+ "  " + rs.getString(3)+ " vs "  + rs.getString(4) + "  " + rs.getString(5)+ "  " +rs.getString(6));
        }
    }
    catch(Exception e) {
         System.out.println(e);
                 }  
    }


public static void main(String[] args){
  
    //searchviaid();
   //searchvianame();
    //searchviastandno();
            printdetails();

}
}
