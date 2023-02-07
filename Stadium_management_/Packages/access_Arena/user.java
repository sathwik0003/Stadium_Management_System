
package access_Arena;
import com.mysql.cj.protocol.Resultset;
import jdbc.*;
import java.util.Scanner;
import java.sql.*;
import java.awt.*;
 
import javax.swing.JOptionPane;
public class user {
	static Scanner sc=new Scanner(System.in);
	
	static public String Username;
	static private String Password;
	static private String Email;
	static private Long Phone_no;
	static private char Gender;
	static private int age;
        static public int userid;

	
	public static int getAge() {
		return age;
	}

	
	public static void setAge(int age) {
		user.age = age;
	}

	public static char getGender() {
		return Gender;
	}

	public static void setGender(char gender) {
		Gender = gender;
	}



	public String getUsername() {
		return Username;
	}



	public void setUsername(String username) {
		Username = username;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public Long getPhone_no() {
		return Phone_no;
	}



	public void setPhone_no(Long phone_no) {
		Phone_no = phone_no;
	}
        public user(){
            
        }
        

	public user(String Username,String Password,String Email,Long Phone_no,int age,char Gender,int userid) {
		user.Username=Username;
		user.Password=Password;
		user.Email=Email;
		user.Phone_no=Phone_no;	
		user.age=age;
		user.Gender=Gender;
                user.userid =userid;
	}


    public static int login_Signup(){
    	System.out.println("Enter 1 to Signup");
    	System.out.println("Enter 0 to Login");
    	int exist=sc.nextInt();
    	return exist;
    }
    public static boolean check(int userid,String Password) throws SQLException {
    	 
   ResultSet rs = selection.getData("select * from user where user_id = '"+userid+"' and password = '"+Password+"'");
         
   while(rs.next()){
            if(rs.getString(8).equals("true"))
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
    
     return false;
    }
    
    public static void createUser() throws SQLException{
    	try{
    	 Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        int login_signup=1;
    	if(login_signup==1) {
    		//insert username password email phone in the table user using jdbc
    		
            System.out.println("Enter Email");
    	    Email=sc.next();
    	    
    	  //Check whether Email is already present in user table
    	    System.out.println("Enter Phone Number");
    	    Phone_no=sc.nextLong();
    	    System.out.println("Enter gender");
    	    Gender=sc.next().charAt(0);
    	    System.out.println("Enter age");
    	    age=sc.nextInt();
    	    //Check whether Phone number is already present in user table
    	    System.out.println("Enter Username");
    	    Username=sc.next();
    	    //Check whether Username is already present in user table
    	    System.out.println("Enter Password");
    	    Password=sc.next();
    	    System.out.println("Account created Successfully");
           
    	    String query = "insert into user(email,phone_no,gender,age,username,password,status) values('"+Email+"','"+Phone_no+"','"+Gender+"','"+age+"','"+Username+"','"+Password+"','"+true+"')";
            Statement st = con.createStatement();
         st.executeUpdate(query);
            //insertion_updation_deletion.setData(query, "successfully registered");
            //JOptionPane.showMessageDialog(null,"successfully inserted ");
            ResultSet rs = selection.getData("select * from user where username='"+ Username+"'");
          
    while(rs.next()){
        userid = rs.getInt(1);
       System.out.println("you're userid for booking is "+userid);
    }
    	}}
        catch(Exception e) {
         System.out.println(e);
                 }
    }
    
    public static boolean login() throws SQLException {
        int k=0;
    	if(k==0) {
    		//The user already have an account
                System.out.println("Enter Userid");
                userid = sc.nextInt();
                
    		//System.out.println("Enter Username");
    	   // Username=sc.next();
 
    	    System.out.println("Enter Password");
    	    Password=sc.next();
    	    if(check(userid,Password)) {
    	    return true;
    	}
    	    else {
    	    System.out.println("Incorrect username,password");
            System.exit(0);
    	    return false;
    }

}
    	return false;}
    
    public void update_email() throws Exception {
        
                       Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        System.out.println("Enter USERID");
        int uid = sc.nextInt();
        		System.out.println("Enter new email to update");
        		Email=sc.next();
                        String query = "update user set email = '"+Email+"'where user_id = '"+uid+"' ";
                        Statement st = con.createStatement();
         st.executeUpdate(query);
                        //insertion_updation_deletion.setData(query, "successfully updated");
        		//update email in database
        	
        }
    public void update_phoneno() throws Exception{
        
                        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        System.out.println("Enter USERID");
        int uid = sc.nextInt();
        		System.out.println("Enter new Phone  number to update");
        		Phone_no=sc.nextLong();
                        String query = "update user set email = '"+Phone_no+"'where user_id = '"+uid+"' ";
                        Statement st = con.createStatement();
         st.executeUpdate(query);
                          //insertion_updation_deletion.setData(query, "successfully updated");
        		//update email in database
        	
        }
    public void update_password() throws Exception{
        
                        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
        System.out.println("Enter USERID");
        int uid = sc.nextInt();
        		System.out.println("Enter new email to update");
        		Password=sc.next();
                        String query = "update user set email = '"+Password+"'where user_id = '"+uid+"' ";
                        Statement st = con.createStatement();
         st.executeUpdate(query);
                          //insertion_updation_deletion.setData(query, "successfully updated");
        		//update phoneno in database
        	
        }
    public void delete_user() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stadium_management","root","12345");
    	System.out.println("Enter Userid");
	    userid=sc.nextInt();

	    System.out.println("Enter Password");
	    Password=sc.next();
	    if(check(userid,Password)) {
	    	String query = "delete from user where user_id = '"+userid+"'";
                Statement st = con.createStatement();
         st.executeUpdate(query);
                  //insertion_updation_deletion.setData(query, "successfully deleted");
	    	
	    }
    }
    public void welcome() throws SQLException {
    	if(login()) {
    		System.out.println("Welcome to aacessARENA Stadium Seat Booking");
    		//should re direct to bookings or match details as prefered by user
    	}
    }
    public static void main(String[] args) throws Exception{
        /*try{
    	createUser();}
        catch(Exception e){
            
        }
        try{
    	login();
        }
        catch(Exception e){
            
        }
        connection.getCon();*/
        user u = new user();
        //u.delete_user();
       // u.login();
        createUser();    
        
    	
    }
}