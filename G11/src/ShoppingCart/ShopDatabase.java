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
public class ShopDatabase {

    Product[] p;
    int count;
    Scanner in = new Scanner(System.in);

    ShopDatabase() {
        p = new Product[1000];
        count = 0;
    }

    public void addDb(Product product) {//add a new item into the database
        if (count < p.length) {
            p[count] = product;
            count++;
        } else {
            System.out.println("Out of range");
        }
    }

    public void setDatabase() {//set some initial items
        addDb(new Product(101, "Milk", 4.00, 1, "liter", 110));
        addDb(new Product(103, "Bread", 1.25, 1, "loaf", 201));
        addDb(new Product(203, "Orange", 0.50, 1, "pc", 300));
        addDb(new Product(123, "Egg", 3.20, 1, "dozen", 100));
    }

    public void setNewProduct() {//ask the user to set each characteristics of the added item
        System.out.print("Enter ID: ");
        int ID = in.nextInt();
        int i;
        for (i = 0; i < p.length; i++) {
            if (p[i] != null && ID == p[i].ID) {
                break;
            }
        }
        if (i == p.length) {
            System.out.print("Enter name: ");
            String name = in.next();
            System.out.print("Enter price: ");
            double price = in.nextDouble();
            System.out.print("Enter quantity: ");
            int quantity = in.nextInt();
            System.out.print("Enter unit: ");
            String unit = in.next();
            System.out.print("Enter stock: ");
            int stock = in.nextInt();
            addDb(new Product(ID, name, price, quantity, unit, stock));
        } else {
            System.out.println("There already have this product");
        }
        
    }

    public void display(Product[] p) {//display all items in the database
        System.out.println("IDNum\tName\tPrice\tQuantity\tUnit\tStock");
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                System.out.println(p[i]);
            }
        }
    }

    public void remove(int ID) {//remove an item with the typed ID in the database
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null && p[i].getID() == ID) {
                p[i] = null;
                for (int j = i; j < p.length - 1; j++) {
                    p[j] = p[j + 1];
                }
            } else {

            }
        }
    }

    public void edit(int ID) {//edit a characteristics of the typed ID
        int i;
        for (i = 0; i < p.length; i++) {
            if (p[i] != null) {
                if (p[i].getID() == ID) {
                    break;
                }
            }
        }
        if (i < p.length) {
            int choice;
            System.out.print("1 - name"
                    + "\n2 - price"
                    + "\n3 - quantity"
                    + "\n4 - unit"
                    + "\n5 - stock"
                    + "\n6 - no change"
                    + "\nEnter your choice: ");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.print("Enter new name: ");
                String nN = in.next();
                p[i].name = nN;
            } else if (choice == 2) {
                System.out.print("Enter new price: ");
                double nP = in.nextDouble();
                p[i].price = nP;
            } else if (choice == 3) {
                System.out.print("Enter new quantity: ");
                int nQ = in.nextInt();
                p[i].quantity = nQ;
            } else if (choice == 4) {
                System.out.print("Enter new unit: ");
                String nU = in.next();
                p[i].unit = nU;
            } else if (choice == 5) {
                System.out.println("Enter new stock: ");
                int nS = in.nextInt();
                p[i].stock = nS;
            } else if (choice == 6) {
                System.out.println("edited");
            } else {
                System.out.println("wrong choice, try again!!");
            }
        } else {
            System.out.println("Item does not exist!!");
        }
    }

}
