/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import ObjectsAndClasses.Teacher;

/**
 *
 * @author 44869
 */
public class EarlyPurchase extends Ticket {

    private int days;//1
    //private double discount = 0;

    public EarlyPurchase(int ticketNumber, double price, int days) {
        super(ticketNumber, price);//1 refers to the superclass' constructor with 2 param
        this.days = days;//1
        //this.discount = discount;
    }

    public double getDiscount() {//1
        double p = 0.0;//1
        if (days >= 10) {
            //discount = 0.1;
            p = super.getPrice() * 0.9;
        } else if (days <= 9) {
            //discount = 0.05;
            p = super.getPrice() * 0.95;//1
        }
        return p;//1
    }

    @Override
    public String toString() {//1
        return super.toString() + "Days in advance: " + days;//1+1
        //System.out.println(super.toString() + "discount: " + discount + "\nnew price: " + super.getPrice() * (1 - discount) + "\ndays: " + days);
    }

}

class testEarlyPurchase {

    public static void main(String[] args) {
        EarlyPurchase e = new EarlyPurchase(123, 60, 9);
        System.out.println(e);
    }
}
