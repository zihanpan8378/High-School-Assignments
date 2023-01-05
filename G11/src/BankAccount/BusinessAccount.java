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
public class BusinessAccount extends BankAccount {

    String BPN;
    int updates = 0;

    BusinessAccount(String a, String BPN) {
        super.accountName = a;
        this.BPN = BPN;
        super.balance = 1000;
    }

    BusinessAccount() {

    }

    public String getBPN() {
        return BPN;
    }

    @Override
    void withdraw(double subtract) {
        super.withdraw(subtract);
        if (super.getBalance() >= subtract && super.balance <= 1000) {
            balance -= 10;
        } else {

        }
    }

    @Override
    void deposit(double add) {
        //super.deposit(add);
        if (add >= 100000) {
            add = add * (1 - 0.12);
        } else {

        }
        super.deposit(add);
    }

    String status() {
        String status;
        if (balance >= 1000) {
            status = "Within limit";
        } else {
            status = "Overdraft";
        }
        return status;
    }

    double updates() {
        //int updates = 0;
        if (status().equals("Overdraft")) {
            updates++;
        } else {
        }
        return updates;
    }

    @Override
    public String toString() {
        return "BusinessAccount\n" + super.toString() + "\nBPN: " + getBPN() + "\nBalance status: " + status() + "\nNumber of overdraft updates: " + updates();
    }

}
