/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginRecordNote;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testLoginRecordNote {

    public static void main(String[] args) {
        Account[] accs = new Account[3];
        accs[0] = new Account("gem", "12345");
        accs[1] = new Account("rom", "12345");
        accs[2] = new Account("rem", "12345");

        LoginRecord lr = new LoginRecord();
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1 - Login"
                    + "\n2 - View login database"
                    + "\n3 - View login record"
                    + "\n0 - quit");
            choice = in.nextInt();

            if (choice == 1) {
                System.out.println("--------------------");
                System.out.println("Enter username: ");
                String user = in.next();
                System.out.println("Enter password: ");
                String pw = in.next();
                Account a = new Account(user, pw);
                lr.verifyLogin(a, accs);
                System.out.println("--------------------");
            } else if (choice == 2) {
                System.out.println("--------------------");
                AccountDatabase adb = new AccountDatabase(accs);
                adb.printDB();
                System.out.println("--------------------");
            } else if (choice == 3) {
                System.out.println("--------------------");
                lr.printAllLogins();
                System.out.println("--------------------");
            } else if (choice == 0) {
                System.out.println("Thank you for using this app...");
            } else {
                System.out.println("Incalid choice...");
            }
        } while (choice != 0);
    }
}