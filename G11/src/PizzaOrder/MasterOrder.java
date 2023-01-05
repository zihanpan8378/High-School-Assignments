/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PizzaOrder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class MasterOrder {

    ArrayList<PizzaOrder> orderList = new ArrayList();

    MasterOrder() {

    }

    public void addOrder(String itemName, int numBoxes, double boxPrice) {
        orderList.add(new PizzaOrder(itemName, numBoxes, boxPrice));
    }

    public void displayOrderList() {
        System.out.println("Name\tNum of Boxes\tPrice per Box");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i).getName()
                    + "\t" + orderList.get(i).getNum()
                    + "\t\t" + orderList.get(i).getpBox());

        }
        System.out.println(getTotalBoxes());
    }

    public int getTotalBoxes() {
        int totalBoxes = 0;
        for (int i = 0; i < orderList.size(); i++) {
            totalBoxes += orderList.get(i).getNum();
        }
        return totalBoxes;
    }

    public int removeVariety(String pizzaName) {
        int num = 0, i;
        do {
            for (i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getName().equals(pizzaName)) {
                    orderList.remove(i);
                    num++;
                    i--;
                    break;
                }
            }
        } while (i != orderList.size());
        return num;
    }

    public void showOrderStat() {
        double totalPrice = 0;
        System.out.println("Name\tNum of Boxes\tPrice per Box\tTotal Box");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i));
            totalPrice += orderList.get(i).getTotalPrice();
        }
        System.out.println("Total price: " + totalPrice);
    }

}

class testMasterOrder {

    public static void main(String[] args) {
        MasterOrder o = new MasterOrder();
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.print("1 - Add"
                    + "\n2 - Display order list"
                    + "\n3 - Remove"
                    + "\n4 - Show order list"
                    + "\n0 - Quit"
                    + "\nEnter your choice: ");
            choice = in.nextInt();

            if (choice == 1) {
                int choiceA;
                System.out.print("Enter flavor: ");
                String name = in.next();
                System.out.print("Enter price per box: ");
                double pBox = in.nextDouble();
                System.out.print("Enter number of boxes: ");
                int nBox = in.nextInt();
                o.addOrder(name, nBox, pBox);
            } else if (choice == 2) {
                o.displayOrderList();
            } else if (choice == 3) {
                System.out.print("Which flavor do you want to remove: ");
                String name = in.next();
                o.removeVariety(name);
            } else if (choice == 4) {
                o.showOrderStat();
            } else if (choice == 0) {
                break;
            }

        } while (choice != 0);
    }
}
