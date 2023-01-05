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
public class testBusinessAccount {

    public static void main(String[] args) {
        //open account
        BusinessAccount ba = new BusinessAccount("Danny Rand", "621000HN");
        System.out.println(ba);
        System.out.println("-----------------");
        System.out.println("");

        //deposit
        ba.deposit(500);
        System.out.println(ba);
        System.out.println("-----------------");
        System.out.println("");

        //withdraw
        ba.withdraw(1000);
        System.out.println(ba);
        System.out.println("-----------------");
        System.out.println("");

        //withdraw
        ba.withdraw(100);
        System.out.println(ba);
        System.out.println("-----------------");
        System.out.println("");

        //deposit
        ba.deposit(200000);
        System.out.println(ba);

    }
}
