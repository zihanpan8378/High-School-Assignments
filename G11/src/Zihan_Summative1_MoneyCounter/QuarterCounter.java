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
public class QuarterCounter extends MoneyCounter {

    double quarters;

    QuarterCounter(double num) {
        quarters = num;
    }

    public double getQuarters() {
        return quarters;
    }

    @Override
    public double getAmount() {
        return getQuarters() / 4;
    }

    @Override
    public String toString() {
        return "Number of quarters: " + (int)getQuarters()
                + "\nAmount: $" + getAmount();
    }

    public static void main(String[] args) {
        QuarterCounter qc = new QuarterCounter(12);
        System.out.println(qc);
    }

}
