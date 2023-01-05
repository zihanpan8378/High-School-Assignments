/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankApp;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {
        
        Bank b = new Bank();
        Scanner in = new Scanner(System.in);
        int choice1, choice2;

        do {
            System.out.print("1 - Database Management\n"
                    + "2 - Account Transaction\n"
                    + "0 - Quit\n"
                    + ">> ");
            choice1 = in.nextInt();

            if (choice1 == 1) {
                do {
                    System.out.print("\t1 - Show ALL accounts (in alphabetical order of last name)\n"
                            + "\t2 - Add account\n"
                            + "\t3 - Delete account\n"
                            + "\t4 - Edit account\n"
                            + "\t0 - Quit \n"
                            + "\t>>	");
                    choice2 = in.nextInt();

                    if (choice2 == 1) {
                        b.displayDatabace();
                    } else if (choice2 == 2) {
                        System.out.print("\t\tEnter first name: ");
                        String fName = in.next();
                        System.out.print("\t\tEnter last name: ");
                        String lName = in.next();
                        System.out.print("\t\tEnter account number: ");
                        int num = in.nextInt();
                        System.out.print("\t\tEnter initial balance: ");
                        double aBalance = in.nextDouble();
                        b.addAccount(fName, lName, num, aBalance);
                        System.out.println("\t\tAccount added successfully...");
                    } else if (choice2 == 3) {
                        System.out.print("\t\tEnter account number: ");
                        int num = in.nextInt();
                        b.deleteAccount(num);
                    } else if (choice2 == 4) {
                        System.out.print("\t\tEnter account number: ");
                        int num = in.nextInt();
                        b.editAccount(num);
                    } else if (choice2 == 0) {
                        System.out.println("\t\tThank you for using Database Management System");
                        break;
                    } else {
                        System.out.println("\t\tWrong choice!!");
                    }
                } while (choice2 != 0);
                
            } else if (choice1 == 2) {
                do {
                    System.out.print("\t1 - Show account info\n"
                            + "\t2 - Balance inquiry\n"
                            + "\t3 - Withdraw\n"
                            + "\t4 - Deposit\n"
                            + "\t0 - Quit\n"
                            + "\t>>	");
                    choice2 = in.nextInt();

                    if (choice2 == 1) {
                        System.out.print("\t\tEnter account number: ");
                        int num = in.nextInt();
                        b.accountInfo(num);
                    } else if (choice2 == 2) {
                        System.out.print("\t\tEnter account number: ");
                        int num = in.nextInt();
                        b.inquiry(num);
                    } else if (choice2 == 3) {
                        System.out.print("\t\tEnter account number: ");
                        int num = in.nextInt();
                        b.withDraw(num);
                    } else if (choice2 == 4) {
                        System.out.print("\t\tEnter account number: ");
                        int num = in.nextInt();
                        b.deposit(num);
                    } else if (choice2 == 0) {
                        System.out.println("\t\tThank you for using Account Management system");
                        break;
                    } else {
                        System.out.println("\t\tWrong choice!!");
                    }
                } while (choice2 != 0);
                
            } else if (choice1 == 0) {
                System.out.println("\tThank you...");
                break;
            } else {
                System.out.println("\tWrong choice!!");
            }
        } while (choice1 != 0);
    }
}
