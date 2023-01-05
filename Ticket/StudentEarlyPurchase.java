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
public class StudentEarlyPurchase extends EarlyPurchase {//1

    //private int ID;
    //private double studentDiscount = 0;

    public StudentEarlyPurchase(int ticketNumber, double price, int days/*, int ID*/) {//2
        super(ticketNumber, price, days);//1
        //this.ID = ID;
    }
    @Override
    public double getPrice(){//1
        return super.getPrice()*0.5;//2
    }
    @Override
    public String toString(){//1
        return super.toString() + "ID required!" + getPrice();//2
    }

    /*public void setPrice() {
        super.getDiscount();
        studentDiscount = 0.5;
        System.out.println(super.newPrice());
        //System.out.println(super.toString() + "discount: " + discount + "\nnew price: " + super.getPrice() * (1 - discount) * studentDiscount + "\ndays: " + days);
    }*/

}

class testStudentEarlyPurchase {

    public static void main(String[] args) {
        StudentEarlyPurchase e = new StudentEarlyPurchase(000, 30.0, 15);
        System.out.println(e);
    }
}
