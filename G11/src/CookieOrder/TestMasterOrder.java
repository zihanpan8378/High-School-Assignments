/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CookieOrder;

import java.util.Scanner;

/**
 *
 * @author maanderson
 */
public class TestMasterOrder {

    public static void main(String[] Args) {
        Scanner input = new Scanner(System.in);
        MasterOrder mo = new MasterOrder();
        int c;
        do {
            System.out.println("");
            System.out.println("1 - Add order");
            System.out.println("2 - Print orders");
            System.out.println("3 - Print total number of boxes");
            System.out.println("4 - Remove variety");
            System.out.println("0 - Quit");
            System.out.print("Enter your choice: ");
            c = input.nextInt();
            if (c == 1) {
                CookieOrder o;
                System.out.print("Enter type of cookie:");
                String cookie = input.next();
                System.out.print("Enter number of boxes: ");
                int num = input.nextInt();
                o = new CookieOrder(cookie, num);
                mo.addOrder(o);
            } else if (c == 2) {
                mo.displayOrders();
            } else if (c == 3) {
                System.out.println("Total boxes: " + mo.getTotalBoxes());
            } else if (c == 4) {
                System.out.print("Enter cookie type: ");
                String coo = input.next();
                System.out.println("Number of Boxes Removed: " + mo.removeVariety(coo));
            }          

        } while (c != 0);
    }
}
