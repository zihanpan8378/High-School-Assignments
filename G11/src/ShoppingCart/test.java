/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {
        ShopDatabase db = new ShopDatabase();
        ShoppingCart c = new ShoppingCart(db);
        Scanner in = new Scanner(System.in);
        int choice;
        db.setDatabase();

        do {
            System.out.print("1 - Database Management\n"
                    + "2 - POS Management\n"
                    + "0 - Exit\n"
                    + ">>	");
            choice = in.nextInt();
            String choice1, choice2;

            if (choice == 1) {
                do {
                    System.out.print("DATABASE MANAGEMENT\n"
                            + "\tR - remove item\n"
                            + "\tE - dit item\n"
                            + "\tA - dd item\n"
                            + "\tD - display all items\n"
                            + "\tQ - uit\n"
                            + "	>>	");
                    choice1 = in.next().toUpperCase();
                    if (choice1.equals("R")) {
                        System.out.print("Enter ID: ");
                        int ID = in.nextInt();
                        db.remove(ID);
                    } else if (choice1.equals("E")) {
                        System.out.print("Enter ID: ");
                        int ID = in.nextInt();
                        db.edit(ID);
                    } else if (choice1.equals("A")) {
                        db.setNewProduct();
                    } else if (choice1.endsWith("D")) {
                        db.display(db.p);
                    } else if (choice1.equals("Q")) {
                        break;
                    } else {
                        System.out.println("Wrong choice, please enter a correct choice!!");
                    }
                } while (!choice1.equals("Q"));
            } else if (choice == 2) {
                do {
                    System.out.print("POS MANAGEMENT\n"
                            + "\tA - dd item to cart\n"
                            + "\tD - isplay cart\n"
                            + "\tP - Pay\n"
                            + "\tR - move\n"
                            + "\tQ - uit\n"
                            + "	>>	");
                    choice2 = in.next().toUpperCase();
                    if (choice2.equals("A")) {
                        int ID;
                        do {
                            System.out.print("Enter IDnum of item to add to car (-1 to QUIT): ");
                            ID = in.nextInt();
                            if (ID != -1) {
                                c.addC(ID);
                            } else {
                                break;
                            }
                        } while (ID != -1);
                    } else if (choice2.equals("D")) {
                        c.display(c.cart);
                    } else if (choice2.equals("P")) {
                        System.out.print("Enter amount: ");
                        double money = in.nextDouble();
                        c.pay(money);
                    } else if (choice2.equals("R")) {
                        System.out.print("Enter ID: ");
                        int ID = in.nextInt();
                        c.remove(ID);
                    } else if (choice2.equals("Q")) {
                        System.out.println("Thank you for shopping…");
                        break;
                    }
                } while (!choice2.equals("Q"));
            } else if (choice == 0) {
                System.out.println("Thank you for using…");
                break;
            } else {
                System.out.println("Wrong choice, please enter a correct choice!!");
            }
        } while (choice != 0);
    }
}
