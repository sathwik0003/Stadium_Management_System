/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package access_Arena;
import jdbc.*;
import java.sql.*;

import java.util.Scanner;
public class admin{
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
	 if(!(employee_id.indexOf('C')==0||employee_id.indexOf('C')==0||employee_id.indexOf('C')==0||employee_id.indexOf('C')==0)) {
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
           
            
		System.out.println("Enter the default password");
		String password=sc.next();
                System.out.println("Enter employee id");
            String employee_id=sc.next();
            check_id(employee_id);
		if(password.equals(12345)) {
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
             
	public static void main(String[] args) throws  Exception {
		 
                      admin a= new admin();
                      a.show_employeedetails();
                            
				 
		 }
	

}

	
	
	


