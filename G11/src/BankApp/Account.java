/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankApp;

/**
 *
 * @author 44869
 */
public class Account extends Person {

    int aNum;
    double aBalance;

    public Account(String fName, String lName, int aNum, double aBalance) {
        super(fName, lName);
        this.aNum = aNum;
        this.aBalance = aBalance;
    }

    public int getaNum() {
        return aNum;
    }

    public void setaNum(int aNum) {
        this.aNum = aNum;
    }

    public double getaBalance() {
        return aBalance;
    }

    public void setaBalance(double aBalance) {
        this.aBalance = aBalance;
    }

    @Override
    public String toString() {
        return aNum + "\t" + super.toString() + "\t" + aBalance;
    }

}
