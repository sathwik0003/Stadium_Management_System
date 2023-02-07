/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package access_Arena;
import jdbc.*;
import java.sql.*;
import java.io.*;

import java.util.Scanner;
import javax.swing.JOptionPane;
class admin{
	static Scanner sc=new Scanner(System.in);
     static String employee_id;
     static Long phone_no;
     static String employee_name;
     static Long Salary;
     static String password = "12345";
     static int Tier;
     
	public static Long getPhone_no() {
		return phone_no;
	}

	public static void setPhone_no(Long phone_no) {
		admin.phone_no = phone_no;
	}

	public static String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		admin.employee_name = employee_name;
	}
	

	public static boolean check_id(String employee_id) {
	 if(!(employee_id.indexOf('C')==0||employee_id.indexOf('F')==0||employee_id.indexOf('E')==0||employee_id.indexOf('S')==0)) {
		return false;
	 }
	 else
		 return true;
	 
	}
	public void create_employee(String employee_id,String employee_name,Long phone_no,Long Salary) {
		admin.employee_id=employee_id;
		admin.employee_name=employee_name;
		admin.phone_no=phone_no;
		admin.Salary=Salary;
		
	}
	public void show_employeedetails() throws Exception {
            try{
            System.out.println("Enter employee id");
            String employee_id=sc.next();
		System.out.println("Enter the default password");
		String password=sc.next();
		if(password.equals(password)) {
		if(employee_id.indexOf('C')==0){
		ResultSet rs = selection.getData("select * from cleaner where employee_id = '"+employee_id+"'");
                ResultSetMetaData rmdb = rs.getMetaData();
                int co = rmdb.getColumnCount();
                while(rs.next()){
                    for(int i=1; i<6; i++){
                        if(i>1) System.out.print(" ");
                       String rm =  rs.getString(i);
                        System.out.println(rm + " " + rmdb.getColumnName(i));
                    }
                }
                }
		else
			System.out.println("Invalid admin password");
                }}
                catch(Exception e) {
         System.out.println(e);
                 }
	

}
}

	
	
	
public class Tier extends admin{
    
    public void addDetailsCleaner() throws Exception
  {
     Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root", "12345");
      Statement stmt = con.createStatement();
      Scanner sc=new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\cleaner.csv"));
      String query="insert into cleaner values(?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(query);
      while(sc.hasNextLine())
      {
         String[] str=sc.nextLine().split(",");
         ps.setString(1, str[0]);
         ps.setString(2, str[1]);
         ps.setLong(3,Long.parseLong(str[2]));
         ps.setInt(4,Integer.parseInt(str[3]));
         ps.setInt(5,Integer.parseInt(str[4]));
         ps.executeUpdate();
      }

  }
    public void addDetailsSecurity() {
         
      try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root", "12345");
      Statement stmt = con.createStatement();
      Scanner sc=new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\security.csv"));
      String query="insert into security values(?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(query);
      while(sc.hasNextLine())
      {
         String[] str=sc.nextLine().split(",");
         ps.setString(1, str[0]);
         ps.setString(2, str[1]);
         ps.setLong(3,Long.parseLong(str[2]));
         ps.setInt(4,Integer.parseInt(str[3]));
         ps.setInt(5,Integer.parseInt(str[4]));
         ps.executeUpdate();
      }
      }
      catch(Exception e){
          System.out.println(e);}
      }
  
    
  
    public void addDetailsChef()
  {
      try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root", "12345");
      Statement stmt = con.createStatement();
      Scanner sc=new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\cooking_department.csv"));
      String query="insert into cooking_department values(?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(query);
      while(sc.hasNextLine())
      {
         String[] str=sc.nextLine().split(",");
         ps.setString(1, str[0]);
         ps.setString(2, str[1]);
         ps.setLong(3,Long.parseLong(str[2]));
         ps.setInt(4,Integer.parseInt(str[3]));
         ps.setInt(5,Integer.parseInt(str[4]));
         ps.executeUpdate();
      }
      }
      catch(Exception e){
          System.out.println(e);}
      }
  
    public void addDetailsEventManager() {
            try
  {
     Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management", "root", "12345");
      Statement stmt = con.createStatement();
      Scanner sc=new Scanner(new File("C:\\Users\\91901\\Desktop\\csv files\\event_manager.csv"));
      String query="insert into event_manager values(?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(query);
      while(sc.hasNextLine())
      {
         String[] str=sc.nextLine().split(",");
         ps.setString(1, str[0]);
         ps.setString(2, str[1]);
         ps.setLong(3,Long.parseLong(str[2]));
         ps.setInt(4,Integer.parseInt(str[3]));
         ps.setInt(5,Integer.parseInt(str[4]));
         ps.executeUpdate();
      }
  }
            catch(Exception e){
                System.out.println(e);
            }

  }
        
	public static void add_employee() throws Exception{
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
		System.out.println("Enter the default password");
		String password=sc.next();
		if(password.equals(password="12345")) {
			System.out.println("Enter employee Id");
		 employee_id = sc.next();
	    System.out.println("Enter Employee_name");
	    employee_name=sc.next();
	    System.out.println("Enter Phone_no");
	    phone_no=sc.nextLong();
	    System.out.println("Enter Salary");
	    Salary=sc.nextLong();
	    if(Salary>20000)
	    	Tier=1;
	    else
	    	Tier=2;
		
		
		if(employee_id.indexOf('C')==0) {
			String query = "insert into cleaner values('"+employee_id+"','"+employee_name+"','"+phone_no+"','"+Salary+"','"+Tier+"')";
			//insertion_updation_deletion.setData(query, "successfully registered");
                        Statement st = con.createStatement();
         st.executeUpdate(query);
                        //JOptionPane.showMessageDialog(null,"successfully inserted ");
			System.out.println("Employee added successfully ");
			}
		if(employee_id.indexOf('F')==0) {
			String query = "insert into cooking_department values('"+employee_id+"','"+employee_name+"','"+phone_no+"','"+Salary+"','"+Tier+"')";
			//insertion_updation_deletion.setData(query, "successfully registered");
                        //JOptionPane.showMessageDialog(null,"successfully inserted ");
                        Statement st = con.createStatement();
         st.executeUpdate(query);
			System.out.println("Employee added successfully ");
			}
		if(employee_id.indexOf('S')==0) {
			String query = "insert into security values('"+employee_id+"','"+employee_name+"','"+phone_no+"','"+Salary+"','"+Tier+"')";
			//insertion_updation_deletion.setData(query, "successfully registered");
                        Statement st = con.createStatement();
         st.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"successfully inserted ");
			System.out.println("Employee added successfully ");
			}
		if(employee_id.indexOf('E')==0) {
			String query = "insert into event_manager values('"+employee_id+"','"+employee_name+"','"+phone_no+"','"+Salary+"','"+Tier+"')";
			//insertion_updation_deletion.setData(query, "successfully registered");
                        Statement st = con.createStatement();
         st.executeUpdate(query);
                        //JOptionPane.showMessageDialog(null,"successfully inserted ");
			System.out.println("Employee added successfully ");
			}}
		else
			System.out.println("Invalid passward");
			
		
		}
	public static void delete_employee() throws Exception{
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
		System.out.println("Enter the default password");
		String password=sc.next();
		if(password.equals(password="12345")) {
		System.out.println("Enter Employee_id");
		employee_id = sc.next();
		if(employee_id.indexOf('C')==0) {
			String query = "delete from cleaner where employee_id = '"+employee_id+"'";
                  //insertion_updation_deletion.setData(query, "successfully deleted");
			Statement st = con.createStatement();
         st.executeUpdate(query);
			System.out.println("Employee deleted successfully ");
			}
		if(employee_id.indexOf('F')==0) {
			String query = "delete from cooking_department where employee_id = '"+employee_id+"'";
                  //insertion_updation_deletion.setData(query, "successfully deleted");
                  Statement st = con.createStatement();
         st.executeUpdate(query);
			System.out.println("Employee deleted successfully ");
			}
		if(employee_id.indexOf('S')==0) {
			String query = "delete from security where employee_id = '"+employee_id+"'";
                  //insertion_updation_deletion.setData(query, "successfully deleted");
			Statement st = con.createStatement();
         st.executeUpdate(query);
			System.out.println("Employee deleted successfully ");
			}
		if(employee_id.indexOf('E')==0) {
			String query = "delete from event_manager where employee_id = '"+employee_id+"'";
                  //insertion_updation_deletion.setData(query, "successfully deleted");
                  Statement st = con.createStatement();
         st.executeUpdate(query);
			System.out.println("Employee deleted successfully ");
			}}
	else
		System.out.println("Invalid password");
		
		}
		@Override
		public  void show_employeedetails() throws Exception {
		System.out.println("Enter the default password");
		String password=sc.next();
		if(password.equals(password)) {
                    System.out.println("Enter 1 for cooking department \nEnter 2 for cleaning department\nEnter 3 for security details\nEnter 4 for event_manager details\n");
                    int i = sc.nextInt();
		if(i==1){
		ResultSet rs = selection.getData("select * from cooking_department");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
                }
                if(i==2){
		ResultSet rs = selection.getData("select * from cleaner");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
                }
                if(i==3){
		ResultSet rs = selection.getData("select * from security");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
                }
                if(i==4){
		ResultSet rs = selection.getData("select * from event_manager");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
                }
                }
		else
			System.out.println("Invalid admin password");
	


}
	public static void main(String[] args) throws  Exception {
		 
                      Tier t= new Tier();
                      //t.show_employeedetails();
                      //t.addDetailsCleaner();
                     t.addDetailsCleaner();
                     // t.addDetailsSecurity();
                      //t.addDetailsEventManager();
                      
                            
				 
		 }
	
}
