/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

/**
 *
 * @author 44869
 */
public class Ticket {

    private int ticketNumber;
    private double price;

    public Ticket(int ticketNumber, double price) {
        this.ticketNumber = ticketNumber;
        this.price = price;
    }

    public Ticket() {
        this.ticketNumber = 000;
        this.price = 50.00;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketNumber=" + ticketNumber + ", price=" + price + '}';
    }

}
