package access_Arena;
import java.io.File;
import java.util.*;
import java.sql.*;

public class ManageStadium implements Booking_Interface {
    
    static Scanner input = new Scanner(System.in);
    
     public static  void addDetails() 
  {
      try{
     Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root", "12345");
      Statement stmt = con.createStatement();
      String q = "create table if not exists Stadium(Stand varchar(30),seats_available int,price int,StandNo int not null auto_increment primary key)";
      stmt.executeUpdate(q);
      Scanner input =new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\stadium.csv"));
      String query="insert into stadium values(?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(query);
      while(input.hasNextLine())
      {
         String[] str=input.nextLine().split(",");
         ps.setString(1, str[0]);
         ps.setInt(2,Integer.parseInt(str[1]));
         ps.setInt(3,Integer.parseInt(str[2]));
         ps.setInt(4,Integer.parseInt(str[3]));
         
         ps.executeUpdate();
      }
      System.out.println("Table inserted successfully");
      }
      catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
  }
     public static void updatedetails(){
    try{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root","12345");
    Statement stmt = con.createStatement();
    String query = "update stadium set Stand = ?,seats_available = ?, price = ? where StandNo=?";
    PreparedStatement ps=con.prepareStatement(query);
    Scanner sc = new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\stadium.csv"));
    while(sc.hasNextLine()){
      String[] str = sc.nextLine().split(",");
      ps.setString(1, str[0]);
      ps.setInt(2,Integer.parseInt(str[1]));
      
      ps.setInt(3,Integer.parseInt(str[2]));
      
      ps.setInt(4,Integer.parseInt(str[3]));
      
      ps.executeUpdate();
    }
    System.out.println("Table updated successfully");
  }
    catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
  }
   
    public static void updateprice(){
        try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        String query = "update stadium set price = ? where StandNo = ?";
         PreparedStatement st1 = con.prepareStatement(query); 
         System.out.println("Enter Stand number to update:");
         int standno = input.nextInt();
         st1.setInt(2, standno);
         
         System.out.println("Enter new price:");
         int price = input.nextInt();
         st1.setInt(1, price);
         
         
         st1.executeUpdate();
        
        }
         catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
    }
    
    
    @Override
    public void showmatches(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        String q3 = "select * from t20_match";
         Statement st4 = con.createStatement();
        ResultSet rs4 = st4.executeQuery(q3);
         System.out.println("MatchId   Date   \tMatch");
        while(rs4.next()){
            System.out.println(rs4.getString(1) + "\t " + rs4.getString(4)+ "\t " + rs4.getString(2) + " vs " + rs4.getString(3));
        }
    }
        catch(Exception e) {
         System.out.println(e);
                 }
    }
    
    @Override
    public void showstand(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from stadium ");
       System.out.println("StandNo  Stand Name \t Price" );
        while(rs.next()){
            System.out.println(rs.getString(4) + "\t " + rs.getString(1) + "\t INR " + rs.getString(3) + "\t  ");
            
        }
        }
        catch(Exception e) {
         System.out.println(e);
                 }
    }
    
    public static void main(String[] args){
        
        ManageStadium b = new ManageStadium();
        //addStand();
        //updateprice();
        //b.showstand();
        //b.showmatches();
        //addDetails();
        updatedetails();
    }
}