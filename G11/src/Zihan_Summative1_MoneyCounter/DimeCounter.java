/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zihan_Summative1_MoneyCounter;

/**
 *
 * @author 44869
 */
public class DimeCounter extends MoneyCounter{
    double dimes;

    DimeCounter(double num) {
        dimes = num;
    }

    public double getDimes() {
        return dimes;
    }

    @Override
    public double getAmount() {
        return getDimes() / 10;
    }

    @Override
    public String toString() {
        return "Number of Dimes: " + (int)getDimes()
                + "\nAmount: $" + getAmount();
    }

    public static void main(String[] args) {
        DimeCounter dc = new DimeCounter(10);
        System.out.println(dc);
    }

}

