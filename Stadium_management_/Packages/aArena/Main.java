package aArena;

import access_Arena.*;
import access_Arena.ODi;
import access_Arena.Booking;
import access_Arena.Food;
import java.util.*;
import java.sql.*;
import jdbc.selection;

/**
 *
 * @author 91901
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int ch=0;
        while(ch!=3){
        System.out.println("Enter 1 if you are USER\nEnter 2 if you are ADMIN\nEnter 3 to exit");
        ch=sc.nextInt();
        {
            if(ch==1){
                System.out.println("Enter 1 to Sign up\nEnter 2 to Login(if you have account registered)\nEnter 3 to update details\nEnter 4 to delete profile");
                int ch1 = sc.nextInt();
                switch (ch1) {
                    case 1:
                        user.createUser();
                    case 2:
                        user.login();
                        System.out.println("welcome to booking page");
                        System.out.println("Enter 1 to proceed booking\nEnter 2 to logout");
                        int i = sc.nextInt();
                        if (i == 1) {
                            Booking b = new Booking();
                            b.showmatches();
                            b.selectmatch();
                            b.showstand();
                            b.bookticket();
                            b.confirm_update_seats();
                            System.out.println("\nEnter 1 to book food\nEnter 2 to logout");
                            int l = sc.nextInt();
                            if (l == 1) {
                                Food f = new Food();
                                f.showfood();
                                f.Bookfood();
                            } else {
                                System.exit(0);
                            }
                            System.exit(0);
                        } else {
                            System.exit(0);
                        }
                        break;
                    case 3: 
                        System.out.println("Enter 1 to update Email\nEnter 2 to update password\nEnter 3 to update phone number");
                        int p = sc.nextInt();
                        if(p==1){
                            user u = new user();
                            
                            
                            u.update_password();
                        }
                        if(p==2){
                            user u = new user();
                            if(u.login()){
                            u.update_email();}
                        }
                        if(p==3){
                            user u = new user();
                            u.login();
                            if(u.login()){
                            u.update_phoneno();}
                        }
                    case 4: 
                        user u = new user();
                        u.delete_user();
                }
            }
            else if(ch==2){ 
                System.out.println("Enter ADMIN password");
                  int pw = sc.nextInt();
                  if(pw==12345){
                System.out.println("Enter 1 to operate employee details\nEnter 2 to operate match details\nEnter 3 to manage stadium\nEnter 4 to manage food operations\nEnter 5 to view booking status of customers:\nEnter 6 to view user and employee details");
                int j = sc.nextInt();
                if (j == 1) {
                    System.out.println("Enter 1 to add employee\nEnter 2 to delete employee\nEnter 3 to show employee");
                    int ch2 = sc.nextInt();
                    switch (ch2) {
                        case 1:
                            Tier.add_employee();
                            break;

                        case 2:
                            Tier.delete_employee();
                            break;
                        case 3:
                            Tier t = new Tier();
                            t.show_employeedetails();
                            break;

                        default:
                            System.out.println("Incorrect choice");
                    }

                }
                if (j == 2) {
                    System.out.println("Enter 1 to add match\nEnter 2 to delete match\nEnter 3 to update match\nEnter 4 to show mathces");
                    int c1 = sc.nextInt();
                    switch (c1) {
                        case 1:
                            System.out.println("Enter 1 to add T20 match\nEnter 2 to add ODi match");
                            int ch3 = sc.nextInt();
                            if (ch3 == 1) {
                                T20.addmatch();
                            } else if (ch3 == 2) {
                                ODi.addmatch();
                            } else {
                                System.out.println("Incorrect choice");
                            }
                            break;

                        case 2:
                            System.out.println("Enter 1 to delete T20 match\nEnter 2 to delete ODi match");
                            int ch4 = sc.nextInt();
                            if (ch4 == 1) {
                                T20.deletematch();
                            } else if (ch4 == 2) {
                                ODi.deletematch();
                            } else {
                                System.out.println("Incorrect choice");
                            }
                            break;
                        case 3:
                            System.out.println("Enter 1 to update T20 match\nEnter 2 to update ODi match");
                            int ch5 = sc.nextInt();
                            if (ch5 == 1) {
                                T20.updatematch_date();

                            } else if (ch5 == 2) {
                                ODi.updatematch_date();
                            } else {
                                System.out.println("Incorrect choice");
                            }
                            break;
                        case 4:
                            System.out.println("Enter 1 to show T20 match\nEnter 2 to show ODi match");
                            int ch6 = sc.nextInt();
                            if (ch6 == 1) {
                                T20.showmatches();
                            } else if (ch6 == 2) {
                                ODi.showmatches();
                            } else {
                                System.out.println("Incorrect choice");
                            }
                            break;
                    }
                }
                if (j == 3) {
                    ManageStadium ms = new ManageStadium();
                    System.out.println("Enter 1 to update details\n2.Enter 2 to update price\nEnter 3 to show matches\nEnter 4 to show stand details\n");
                    int c2 = sc.nextInt();
                    switch (c2) {
                        case 1:
                            ManageStadium.updatedetails();
                            break;
                        case 2:
                            ManageStadium.updateprice();
                            break;
                        case 3:
                            ms.showmatches();
                            break;
                        case 4:
                            ms.showstand();
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                }
                if (j == 4) {
                    Food f1 = new Manage_Food();
                    System.out.println("Enter 1 to update foodMenu\nEnter 2 to search food item via id\nEnter 3 to search via category\nEnter 4 to search via price\nEnter 5 to delete food item\nEnter 6 to print food menu\n ");
                    int c3 = sc.nextInt();
                    switch (c3) {
                        case 1:
                            Manage_Food.updateMenu();
                            break;
                        case 2:
                            Manage_Food.searchfoodviaId();
                            break;
                        case 3:
                            Manage_Food.searchviacategory();
                            break;
                        case 4:
                            Manage_Food.searchviaprice();
                            break;
                        case 5:
                            Manage_Food.deleteitem();
                            break;
                        case 6:
                            f1.showfood();
                            break;
                        default:
                            System.out.println("Enter Valid Input");

                    }
                }
                if (j == 5) {
                    System.out.println("Enter 1 to search via Id\nEnter 2 to search via username\nEnter 3 to search via Stand Number\n Enter 4 to print details");
                    int c4 = sc.nextInt();
                    switch (c4) {
                        case 1:
                            Booking_status.searchviaid();
                            break;
                        case 2:
                            Booking_status.searchvianame();
                            break;
                        case 3:
                            Booking_status.searchviastandno();
                            break;
                        case 4:
                            Booking_status.printdetails();
                            break;
                        default:
                            System.out.println("Enter valid input");
                            break;

                    }
                }
                if(j==6){
                     System.out.println("Enter 1 to view a particular employee via id\nEnter 2 for user admin details");
                     int n = sc.nextInt();
                     if(n==1){
                         admin_showdetails a = new admin_showdetails();
                         a.search_via_empId();
                     }
                     if(n==2){
                         admin_showdetails a = new admin_showdetails();
                         a.user_employee();
                     }
    }
                    
                }
                else{
                      System.out.println("Incorrect admin password");
                      System.exit(0);
        }
                  
                  }
         if(ch==3){
             System.exit(0);
         }  }
          
        }
        }

    }



