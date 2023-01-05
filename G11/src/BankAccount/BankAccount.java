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
public class BankAccount {

    double balance = 0;
    String accountName;

    BankAccount(String a) {
        accountName = a;
    }

    BankAccount() {

    }

    public double getBalance() {
        return balance;
    }

    void deposit(double add) {
        balance = balance + add;
        getBalance();
    }

    void withdraw(double subtract) {
        if (balance >= subtract) {
            balance -= subtract;
        } else {
            System.out.println("Not wnought money in the account!");
        }
        getBalance();
    }

    public String toString() {
        return "Name: " + accountName + " | Balance: " + getBalance();
    }
}
