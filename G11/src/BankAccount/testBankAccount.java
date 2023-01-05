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
public class testBankAccount {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Johnny Hill");
        //printing after opening an account
        System.out.println(ba);

        ba.deposit(100);
        //printing after making a deposit
        System.out.println(ba);

        ba.withdraw(50);
        //printing after withdrawal #1
        System.out.println(ba);

        ba.withdraw(200);
        //printing after withdrawal #2 where balance < withdrawal
        System.out.println(ba);

    }

}
