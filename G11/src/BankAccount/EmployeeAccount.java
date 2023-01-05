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
public class EmployeeAccount extends BankAccount {

    EmployeeAccount(String a) {
        super(a);
        super.balance = 500;
    }

    EmployeeAccount() {

    }

    @Override
    void withdraw(double subtract) {
        super.withdraw(subtract);
        if (super.balance <= 500) {
            balance -= 2;
        } else {

        }
    }

    /*@Override
    void deposit(double add) {
        super.deposit(add);
        if (super.balance <= 500) {
            balance -= 2;
        } else {

        }
    }*/

    @Override
    public String toString() {
        return "Employee Account:\n" + super.toString();
    }

}
