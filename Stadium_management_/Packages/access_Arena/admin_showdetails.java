/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package access_Arena;
import static access_Arena.admin.sc;
import jdbc.*;
import java.sql.*;

import java.util.Scanner;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author 91901
 */
public class admin_showdetails{
    public  void search_via_empId() throws Exception{
        Scanner sc=new Scanner(System.in);
        // Searching with primary key
        System.out.println("Enter 1 for cooking employees\nEnter 2 for cleaning employees\nEnter 3 for security\nEnter 4 for event_manager");
        int r = sc.nextInt();
        if(r==1){
            System.out.println("Enter employee_id");
            String empId = sc.next();
        ResultSet rs = selection.getData("select * from cooking_department where employee_id='"+empId+"'");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
    }
        if(r==2){
            System.out.println("Enter employee_id");
            String empId = sc.next();
        ResultSet rs = selection.getData("select * from cleaner where employee_id='"+empId+"'");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
    }
        if(r==3){
            System.out.println("Enter employee_id");
            String empId = sc.next();
        ResultSet rs = selection.getData("select * from security where employee_id='"+empId+"'");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
    }
        if(r==4){
            System.out.println("Enter employee_id");
            String empId = sc.next();
        ResultSet rs = selection.getData("select * from event_manager where employee_id='"+empId+"'");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
    }
    }
    public void user_employee() throws Exception{
        System.out.println("Enter 1 to see employee details\nEnter 2 to see user detaials \n");
        Scanner sc=new Scanner(System.in);
        int k = sc.nextInt();
        if(k==1){
            System.out.println("Enter the default password");
		String password=sc.next();
		if(password.equals(12345)) {
                    System.out.println("Enter 1 for cooking department \nEnter 2 for cleaning department\nEnter 3 for security details\nEnter 4 for event_manager details\n");
                    int i = sc.nextInt();
		if(i==1){
                    // search through partial string
		ResultSet rs = selection.getData("select * from cooking_department where employee_id like '%F%'");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
                }
                if(i==2){
                    // search through partial string
		ResultSet rs = selection.getData("select * from cleaner where employee_id like '%C%'");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
                }
                if(i==3){
                    // search through partial string 
		ResultSet rs = selection.getData("select * from security where employee_id like '%S%'");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
                }
                if(i==4){
                    //search through partial key
		ResultSet rs = selection.getData("select * from event_manager where employee_id like'%E%'");
    while(rs.next()){
       System.out.println("id:"+rs.getString(1)+ "  name:" + rs.getString(2)+ "   ph_no"  + rs.getString(3) + " salary" + rs.getString(4)+" tier"+ rs.getString(5));
    }
                }
                }
		else
			//System.out.println("Invalid admin password");
                search_via_empId();
	
        }
        if(k==2){
            ResultSet rs = selection.getData("select * from user");
    while(rs.next()){
       System.out.println("userid:"+rs.getString(1)+ "  username:" + rs.getString(4)+ "   Email"  + rs.getString(2) + " phone number:" + rs.getString(3));
    }
        }
    }
    public static void main(String[] args) throws Exception{
        admin_showdetails a = new admin_showdetails();
        a.user_employee();
    }
}
