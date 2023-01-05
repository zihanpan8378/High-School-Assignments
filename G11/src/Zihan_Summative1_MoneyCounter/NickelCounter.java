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
public class NickelCounter extends MoneyCounter{
    double nickel;

    NickelCounter(double num) {
        nickel = num;
    }

    public double getNickels() {
        return nickel;
    }

    @Override
    public double getAmount() {
        return getNickels() / 20;
    }

    @Override
    public String toString() {
        return "Number of Dimes: " + (int)getNickels()
                + "\nAmount: $" + getAmount();
    }

    public static void main(String[] args) {
        NickelCounter nc = new NickelCounter(10);
        System.out.println(nc);
    }

}
