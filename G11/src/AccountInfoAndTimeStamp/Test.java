/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountInfoAndTimeStamp;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Test {
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        LoginRecord ar = new LoginRecord();
        ar.a.setDatabace("qwer", "1234");
        ar.a.setDatabace("asdf", "2345");
        ar.a.setDatabace("zxcv", "3456");
        ar.a.setDatabace("wert", "4567");
        ar.a.setDatabace("sdfg", "5678");
        ar.a.setDatabace("xcvb", "6789");
        int choice;
        
        do {
            System.out.print("\n\n"
                    + "1 - Login\n"
                    + "2 - View login database\n"
                    + "3 - View login record\n"
                    + "0 - to QUIT\n"
                    + "Enter your choice: ");
            choice = in.nextInt();
            System.out.println("----------------");
            if (choice == 1) {
                System.out.print("Enter username: ");
                String usearname = in.next();
                System.out.print("Enter password: ");
                String password = in.next();
                if (ar.verifyLogin(usearname, password) == true) {
                    System.out.println("Account added to record...");
                } else {
                    System.out.println("Username and password don't match or exist!!!");
                }
                ar.addLoginToRecord(new Login(usearname, password));
            } else if (choice == 2) {
                System.out.println("DATABASE");
                System.out.println("Username\tPassword");
                System.out.println(ar.a);
            } else if (choice == 3) {
                if (ar.l[0] == null) {
                    System.out.println("No login record to show!");
                } else {
                    System.out.println("LOGIN RECORD");
                    ar.displayRecord(ar.l);
                }
            } else if (choice == 0) {
                break;
            }
        } while (choice != 0);
    }
}