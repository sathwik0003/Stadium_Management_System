package access_Arena;
import java.util.*;
import java.sql.*;

/**
 *
 * @author PRANEET
 */
public class Booking extends user implements Booking_Interface  {
    
    public static int Match_id;
    public static int Stand_no;
    public static int no_of_seats;
    public static int price;
    
    public static String TeamA;
    public static String TeamB;
    public static String MDate;
    public static String Stand;
    
    
    static Scanner input = new Scanner(System.in);
    @Override
    public void showmatches(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        String q3 = "select * from t20_match";
         Statement st4 = con.createStatement();
        ResultSet rs4 = st4.executeQuery(q3);
        System.out.println("MatchId   Date   \t Match");
         
        while(rs4.next()){
            System.out.println(rs4.getString(1) + "\t  " + rs4.getString(4)+ "\t " + rs4.getString(2) + " vs " + rs4.getString(3));
        }
    }
        catch(Exception e) {
         System.out.println(e);
                 }
    }
    
    public void selectmatch(){
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        
        String q2 = "select * from t20_match where Match_id = ?";
         PreparedStatement st3 = con.prepareStatement(q2);  
         
        
        System.out.println("Select the Match ID");
        Match_id = input.nextInt();
         st3.setInt(1, Match_id);
        
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
            System.out.println(rs.getString(4) + "\t " + rs.getString(1) + "\t INR " + rs.getString(3));
            
        }
        }
        catch(Exception e) {
         System.out.println(e);
                 }
    }
    
    public void bookticket(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        
        System.out.println("Enter the Stand Number: ");
         Stand_no =input.nextInt();
        System.out.println("Enter no of seats to book:");
        no_of_seats = input.nextInt();
       
        }
        
        catch(Exception e) {
         System.out.println(e);
                 }
    }
    
    public void confirm_update_seats(){
          try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        String q1= "select * from Matches_stadium where StandNo='"+Stand_no+"' and Match_id = '"+Match_id+"'";
        Statement st2 = con.createStatement();
        ResultSet rs2 = st2.executeQuery(q1);
        
        while(rs2.next()){
        int id =rs2.getInt(1);
        int stand = rs2.getInt(8);
        int availability = rs2.getInt(6);
        int cost = rs2.getInt(7);
       
        String query = "update Matches_stadium set seats_available = seats_available - ? where  Match_id = ?  and StandNo = ? ";
        PreparedStatement st1 = con.prepareStatement(query);
         st1.setInt(3,Stand_no );
         st1.setInt(1,no_of_seats);
         st1.setInt(2,Match_id);
        
        if(id == Match_id && stand==Stand_no && availability>=no_of_seats && no_of_seats<=5){
            System.out.println("confirm you're id");
            int i = input.nextInt();
        System.out.printf("Please pay INR %d\n",no_of_seats*(cost));
        System.out.println("Enter 1 to proceed with payment");
        int n = input.nextInt();
        switch(n){
            case 1:{
                System.out.println("Congratulations,Your Booking is Successfull");
                printticket(i);
                 st1.executeUpdate();
                 
                break;
            }
            default:
                System.out.println("Thank you,Do Visit Again");
            
            
        }
       
        }
        else{
            System.out.println("Sorry,No Seat Available");
            System.out.println("Please try in different stand or Try to decrease the no of seats");
            
        }
          }
          }
        catch(Exception e) {
         System.out.println(e);
                 } 
    }
    
    public void printticket(int Id){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
       String query = "select * from user";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            if(Id == rs.getInt("user_id"))
            {
                System.out.println("           Your Booking Details");
                System.out.println( "User ID :" + rs.getInt(1)+"\nUser Name : " + rs.getString(6) + "");
                int userid = rs.getInt(1);
                String name = rs.getString(6);
                getBookingdetails(Match_id,Stand_no);
            
            
    
    String q = "insert into booking_status values(?,?,?,?,?,?)";
    PreparedStatement st2 = con.prepareStatement(q);
    st2.setInt(1,userid);
    st2.setString(2,name);
    st2.setString(3,TeamA);
    st2.setString(4,TeamB);
    st2.setString(5,Stand);
    st2.setInt(6,Stand_no);
    st2.executeUpdate();
    
    
            }
            } 
        
    }
    catch(Exception e) {
         System.out.println(e);
                 }
}
    
    public void getBookingdetails(int Match_id,int Stand_no){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        String query = "select * from Matches_stadium where Match_id = '"+Match_id+"' and StandNo = '"+Stand_no+"' ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            System.out.println("Match : "+ rs.getString(2) + "  vs  " + rs.getString(3) + "\nDate:" + rs.getString(4) +  "\nStand Name :" + rs.getString(5));
           TeamA = rs.getString(2);
           TeamB = rs.getString(3);
           Stand = rs.getString(5);
            int a = rs.getInt(6);
            int b = a + no_of_seats;
            System.out.print("Your Seat Number(s) is/are ");
            for(int i = a;i<b;i++){
                System.out.printf("%d ",i);
            }
        }
        
        }
        catch(Exception e) {
         System.out.println(e);
            
        }
    }
    

   
    public static void main(String[] args) {
        
        
       Booking b = new Booking();
        
     b.showmatches();
     b.selectmatch();
      b.showstand();
      b.bookticket();
      b.confirm_update_seats();
      //b.printticket(1);
        
      
    }
    
    }