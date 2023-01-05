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

    boolean student;

    public StudentEarlyPurchase(int ticketNumber, double price, int days, boolean student) {//2
        super(ticketNumber, price, days);//1
        this.student = student;
        
    }

    public String checkStudent(){
        String c;
        if (student == true) {
            c = "Is a student";
        } else {
            c = "Is not a student";
        }
        return c;
    }
    
    @Override
    public double getDiscount() {//1
        if (student == true) {
            return super.getDiscount()* 0.5;//2
        } else {
            return super.getDiscount();
        }
    }

    @Override
    public String toString() {//1
        return checkStudent() + "\n" + super.toString();//2
    }

}

class testStudentEarlyPurchase {
    public static void main(String[] args) {
        StudentEarlyPurchase e = new StudentEarlyPurchase(000, 30.0, 15, false);
        System.out.println(e);
    }
}
