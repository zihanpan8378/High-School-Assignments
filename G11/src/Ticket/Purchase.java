/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Purchase extends Buyer {

    int age, days;
    int count;
    StudentEarlyPurchase[] t;

    public Purchase(String fN, String lN, String address, double postalFee, int length) {
        super(fN, lN, address, postalFee);
        t = new StudentEarlyPurchase[length];
    }

    public void add(StudentEarlyPurchase a) {

        if (count < this.t.length) {
            this.t[count] = a;
            count++;
        } else {
            System.out.println("Out of range");
        }
    }

    public double totalPrice(StudentEarlyPurchase[] p) {
        double total = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                total += p[i].getDiscount();
            }
        }
        return total + super.getPostalFee();
    }

    public void remove(int num) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] != null && t[i].getTicketNumber() == num) {
                for (int j = i; j < t.length - 1; j++) {
                    t[j] = t[j + 1];
                    t[j + 1] = null;
                }
                i--;
            }
        }
    }

    public void print(StudentEarlyPurchase[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                System.out.println(p[i] + "\n");
            }
        }
    }

    public void printOne(int num) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] != null && t[i].getTicketNumber() == num) {
                System.out.println(t[i]);
            }
        }
    }

    public void update(int index, StudentEarlyPurchase s) {
        if (t[index] != null) {
            t[index] = s;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

class testPurchase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String fname = in.next();
        System.out.println("Enter your lase name: ");
        String lname = in.next();
        System.out.println("Enter your address: ");
        String address = in.next();
        System.out.println("Enter the postal fee to your address: ");
        double fee = in.nextDouble();
        System.out.println("How many do you want to add at most? ");
        int length = in.nextInt();
        Purchase p = new Purchase(fname, lname, address, fee, length);
        System.out.println(p + "\n\n");
        System.out.println("What do you want to do? "
                + "\n1. add"
                + "\n2.print all"
                + "\n3.print one"
                + "\n4.remove"
                + "\n5.update"
                + "\n0.quit");
        int choice = 1;
        do {
            choice = in.nextInt();
            if (choice == 1) {
                boolean c = false;
                System.out.println("\nTicket number: ");
                int num = in.nextInt();
                System.out.println("Price: ");
                double price = in.nextDouble() + fee;
                System.out.println("Days before using: ");
                int days = in.nextInt();
                System.out.println("Is you a student?\nyes - 1\nno - 0");
                int check = in.nextInt();
                if (check == 1) {
                    c = true;
                } else {
                    c = false;
                }
                p.add(new StudentEarlyPurchase(num, price, days, c));
            } else if (choice == 2) {
                p.print(p.t);
            } else if (choice == 3) {
                System.out.println("Enter the ticket number: ");
                int tnp = in.nextInt();
                p.printOne(tnp);
            } else if (choice == 4) {
                System.out.println("Enter the ticket number: ");
                int tnr = in.nextInt();
                p.remove(tnr);
            } else if (choice == 5) {
                System.out.println("Which index do you want to update");
                int ind = in.nextInt() - 1;
                System.out.println("What do you want to change?"
                        + "\n1.Ticket number"
                        + "\n2.Price"
                        + "\n3.Days"
                        + "\n4.Student");
                int choice2 = in.nextInt();
                if (choice2 == 1) {
                    System.out.println("Enter ticket number: ");
                    int newN = in.nextInt();
                    StudentEarlyPurchase s = new StudentEarlyPurchase(newN,
                            p.t[ind].getDiscount(), p.t[ind].getDays(), p.t[ind].student);
                    p.update(ind, s);
                } else if (choice2 == 2) {
                    System.out.println("Enter price: ");
                    double newP = in.nextDouble();
                    StudentEarlyPurchase s = new StudentEarlyPurchase(p.t[ind].getTicketNumber(),
                            newP, p.t[ind].getDays(), p.t[ind].student);
                    p.update(ind, s);
                } else if (choice2 == 3) {
                    System.out.println("Enter days: ");
                    int newD = in.nextInt();
                    StudentEarlyPurchase s = new StudentEarlyPurchase(p.t[ind].getTicketNumber(),
                            p.t[ind].getDiscount(), newD, p.t[ind].student);
                    p.update(ind, s);
                } else if (choice2 == 4) {
                    boolean newS = false;
                    System.out.println("Is he/she a student?\nyes - 1\nno - 0");
                    int check2 = in.nextInt();
                    if (check2 == 1) {
                        newS = true;
                    } else {
                        newS = false;
                    }
                    StudentEarlyPurchase s = new StudentEarlyPurchase(p.t[ind].getTicketNumber(),
                            p.t[ind].getDiscount(), p.t[ind].getDays(), newS);
                    p.update(ind, s);
                }
            } else if (choice == 0) {
                break;
            }
        } while (choice != 0);

    }
}
/*extends = is-a
implements = is-a*/
