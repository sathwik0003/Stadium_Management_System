package access_Arena;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author anees
 */
public class Food {
    static String url="jdbc:mysql://localhost:3306/stadium_management";
    static String uname="root";
    static String pass="12345";
    
    static Scanner input = new Scanner(System.in);
    
    public static int foodid;
    public static int quantity;
    public static String Category;
     public static String Name;
      public static int price;
     
      
    
        
    public void showfood(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from food ");
        
        while(rs.next()){
            System.out.println(rs.getInt(1) +"  " + rs.getString(2)+ " \t " + rs.getString(3)+"\t INR "+rs.getInt(4));
        }
        
        
    }
        catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
    }
    
    public  void Bookfood(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        
        String  Query= "update food set quantity = quantity - ? where Foodid = ?";
        PreparedStatement st1 = con.prepareStatement(Query); 
         int b=0;
         int x=1;
        while(x != 0){
        System.out.println("Enter item no:");
        int foodid = input.nextInt();
        st1.setInt(2, foodid);
        System.out.println("Enter Quantity:");
        int quantity = input.nextInt();
        st1.setInt(1, quantity);
       
        
         String q1= "select * from food where Foodid ='"+foodid+"'";
        Statement st2 = con.createStatement();
        ResultSet rs2 = st2.executeQuery(q1);
        
        
     
      while(rs2.next()){
        int sno = rs2.getInt(1);
        int availability = rs2.getInt(5);
        int cost = rs2.getInt(4);
        if(sno==foodid && availability>=quantity){
            if(quantity>0){
                st1.executeUpdate();
                b = b + quantity*cost;
                System.out.printf("For item, price is : %d/-\n ",quantity*(cost));
                
            }
            else{
                System.out.println("Please enter a valid quantity!!!");
                x=0;
            }
        }
        else{
            System.out.println("Sorry,No Stock Available");
            System.out.println("Please try different item");
            x=0;
        }
      }
      System.out.printf("Enter 1 to add\n");
      System.out.printf("Enter 0 to proceed to payment");
      x = input.nextInt();
      
    }
        
       System.out.printf("Please pay INR : %d\n1 to proceed payment",b);
       int i = input.nextInt();
       if(i==1){
           System.out.println("Thanks for payment ");
       }
    }
        
        
        catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
        
    }
        
    public static void main(String[] args) {

    
        Food f = new Food();
        f.showfood();
        //Bookfood();
         
    }
    
}