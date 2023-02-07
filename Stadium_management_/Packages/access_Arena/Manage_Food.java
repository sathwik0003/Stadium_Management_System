package access_Arena;
import java.io.*;
import java.sql.*;
import java.util.*;



/**
 *
 * @author anees
 */
public class Manage_Food extends Food {
   
   
   //static Scanner input  = new Scanner(System.in);
   
   public Manage_Food(){
       
   }
   
    public static void addFood(){
    try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        String Query = "insert into food(Category,Name,price,quantity) values(?,?,?,?)";
        PreparedStatement st1 = con.prepareStatement(Query); 
        System.out.println("Enter category of Food Item");
        Category = input.nextLine();
        st1.setString(1,Category);
         System.out.println("Enter Name of Food Item");
        Name = input.nextLine();
        st1.setString(2,Name);
        System.out.println("Enter price of Food Item");
        price = input.nextInt();
        st1.setInt(3,price);
        System.out.println("Enter quantity avaliable:");
        quantity = input.nextInt();
        st1.setInt(4,quantity);
        
        st1.executeUpdate();
        
                
        
        
}
     catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
    }

    public static void addFoodMenu()
  {
      try{
     Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root", "12345");
      Statement stmt = con.createStatement();
  String q =  "create table if not exists food(Foodid int not null auto_increment primary key,Category varchar(30),Name varchar(30),price int,quantity int)";
  stmt.executeUpdate(q);
  
      Scanner sc=new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\food (1).csv"));
      String query="insert into food values(?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(query);
      while(sc.hasNextLine())
      {
         String[] str=sc.nextLine().split(",");
        ps.setInt(1, Integer.parseInt(str[0]));
         ps.setString(2,str[1]);
         ps.setString(3,str[2]);
         ps.setInt(4,Integer.parseInt(str[3]));
         ps.setInt(5,Integer.parseInt(str[4]));
         ps.executeUpdate();
      }
      System.out.println("Table inserted successfully!!!");
      }
      catch(Exception e){
          System.out.println(e);
                 System.out.println("fail");}

      
  }
    
    public static void updateMenu(){
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root","12345");
    //Statement stmt = con.createStatement();
    String query = "update food set Category=?,Name=?,price=?,quantity=? where Foodid=?";
    PreparedStatement ps=con.prepareStatement(query);
    Scanner sc = new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\food (1).csv"));
    while(sc.hasNextLine()){
      String[] str = sc.nextLine().split(",");
      ps.setString(1, str[1]);
     ps.setString(2, str[2]);
      ps.setInt(3,Integer.parseInt(str[3]));
      ps.setInt(4,Integer.parseInt(str[4]));
      ps.setString(5, str[0]);
      ps.executeUpdate();
    }
    System.out.println("Successfully updated!!!");
  }
        catch(Exception e){
          System.out.println(e);
                 System.out.println("fail");}
    }
    
    public static void updateprice(){
        try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        String query = "update food set price = ? where foodid = ?";
         PreparedStatement st1 = con.prepareStatement(query); 
         System.out.println("Enter food id to update:");
         foodid = input.nextInt();
         st1.setInt(2, foodid);
         
         System.out.println("Enter new price:");
         price = input.nextInt();
         st1.setInt(1, price);
         
         
         st1.executeUpdate();
        System.out.println("Price updated successfully");
        }
        
         catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
    }
    
    
      public static void updatequantity(){
        try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        String query = "update food set quantity = ? where foodid = ?";
         PreparedStatement st1 = con.prepareStatement(query); 
         System.out.println("Enter food id to update:");
         foodid = input.nextInt();
         st1.setInt(2, foodid);
         
         System.out.println("Enter new quantiy:");
         quantity = input.nextInt();
         st1.setInt(1, quantity);
         
         
         st1.executeUpdate();
        System.out.println("Quantity updated successfully");
        }
         catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
    }
        
     public static void searchfoodviaId(){
         try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
       
        System.out.println("Select foodid to search");
        foodid = input.nextInt();
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from food where foodid ='"+foodid+"'");
        while(rs.next()){
            System.out.println(rs.getInt(1) +"  " + rs.getString(2)+ " " + rs.getString(3)+ " INR "  + rs.getInt(4));
        }
        
        
     } 
          catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
    }
     
     public static void searchviacategory(){
         try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        
        System.out.println("Select foodcategory to search");
        Category = input.nextLine();
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from food where Category ='"+Category+"'");
        while(rs.next()){
            System.out.println(rs.getInt(1) +"  " + rs.getString(2)+ " " + rs.getString(3)+ " INR "  + rs.getInt(4));
        }
        
         
     }
         catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
         
         
    }
    
     public static void searchviaprice(){
         try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        
        System.out.println("Select max price to search items");
        price = input.nextInt();
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from food where price < '"+price+"'");
        while(rs.next()){
            System.out.println(rs.getInt(1) +"  " + rs.getString(2)+ " " + rs.getString(3)+ " INR "  + rs.getInt(4));
        }
        
         
     }
         catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
     }
     
     public static void deleteitem(){
         try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        
        System.out.println("Enter food id to delete");
        foodid = input.nextInt();
        
        String query = "delete from food where Foodid = '"+foodid+"'";
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        
         System.out.println("Item deleted successfully");
     }
         catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
     }
     
     @Override
      public void showfood(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from food");
        
        while(rs.next()){
            System.out.println(rs.getInt(1) +" \t " + rs.getString(2)+ " \t " + rs.getString(3)+"\t" + " INR "+rs.getInt(4));
        }
        
    }
        catch(Exception e) {
         System.out.println(e);
                 System.out.println("fail");}
    } 
     

    public static void main(String[] args) {
        
        Food f = new Manage_Food();
        /*addFood();
        updateprice();
        updatequantity();
        searchfoodviaId();
        searchviacategory();
        searchviaprice();
        deleteitem();*/
        //f.showfood();
        
        //addFoodMenu();
        updateMenu();
    
}
}