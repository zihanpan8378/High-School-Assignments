/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CookieOrder;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testOrder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MasterOrder goodies = new MasterOrder();
        
        goodies.addOrder(new CookieOrder("Chocolate Chip", 1));
        goodies.addOrder(new CookieOrder("Shortbread", 5));
        goodies.addOrder(new CookieOrder("Macaroon", 2));
        goodies.addOrder(new CookieOrder("Chocolate Chip", 3));

        int choice;
        do {
            System.out.println("1 - Add Order");
            System.out.println("2 - Print Orders");
            System.out.println("3 - Print Total Number of Boxes");
            System.out.println("4 - Remove Variety");
            System.out.println("0 -  quit");
            System.out.println("Enter your choice: ");
            int c = in.nextInt();
            choice = c;

            if (choice == 1) {
                System.out.println("Enter Variety: ");
                String v = in.next();
                System.out.println("Enter the Number of Boxes: ");
                int b = in.nextInt();
                goodies.addOrder(new CookieOrder(v, b));
            }

            if (choice == 2) {
                goodies.displayOrders();
            }

            if (choice == 3) {
                System.out.println("Total boxes: " + goodies.getTotalBoxes());
            }
            
            if (choice == 4) {
                System.out.println("Enter Variety: ");
                //String v = in.next();
                System.out.println("Removed: " + goodies.removeVariety("Chocolate Chip"));
            }
            
            if (choice == 0) {
                
            }
            
            System.out.println("\n\n");

        } while (choice != 0);

    }
}
