/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankAccount;

/**
 *
 * @author 44869
 */
public class testEmployeeAccount {

    public static void main(String[] args) {
        EmployeeAccount ea = new EmployeeAccount("John Smith");

        //printing after opening an employee account
        System.out.println(ea);

        ea.deposit(200);
        //printing after deposit #1
        System.out.println(ea);

        ea.withdraw(400);
        //printing after withdrawal #1
        System.out.println(ea);

        ea.withdraw(100);
        //printing after withdrawal #2
        System.out.println(ea);

        ea.deposit(1000);
        //printing after deposit #2
        System.out.println(ea);

        ea.withdraw(100);
        //printing after withdrawal #3
        System.out.println(ea);

    }
}
