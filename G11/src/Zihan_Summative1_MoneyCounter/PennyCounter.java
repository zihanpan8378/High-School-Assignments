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
public class PennyCounter extends MoneyCounter{
    double pennies;

    PennyCounter(double num) {
        pennies = num;
    }

    public double getPennies() {
        return  pennies;
    }

    @Override
    public double getAmount() {
        return getPennies() / 100;
    }

    @Override
    public String toString() {
        return "Number of Dimes: " + (int)getPennies()
                + "\nAmount: $" + getAmount();
    }

    public static void main(String[] args) {
        PennyCounter pc = new PennyCounter(7);
        System.out.println(pc);
    }
}
