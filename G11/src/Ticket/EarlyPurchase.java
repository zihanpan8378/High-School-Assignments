/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import Person.Teacher;

/**
 *
 * @author 44869
 */
public class EarlyPurchase implements Ticket {

    int days;//1
    int ticketNumber;
    double price;

    public EarlyPurchase(int ticketNumber, double price, int days) {
        //super(ticketNumber, price);//1 refers to the superclass' constructor with 2 param
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.days = days;//1
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public int getTicketNumber() {
        return ticketNumber;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getDiscount() {//1
        double p = 0.0;//1
        if (getDays() >= 10) {
            p = getPrice() * 0.9;
        } else if (getDays() <= 9 && getDays() >= 5) {
            p = getPrice() * 0.95;//1
        } else {
            p = getPrice();
        }
        return p;//1
    }

    @Override
    public String toString() {//1
        return "Ticknet number: " + getTicketNumber()
                + "\nOriginal price: " + getPrice()
                + "\nDays in advance: " + getDays()
                + "\nPrice: " + this.getDiscount();//1+1
    }

}

class testEarlyPurchase {

    public static void main(String[] args) {
        EarlyPurchase e = new EarlyPurchase(123, 60, 20);
        System.out.println(e);
    }
}
