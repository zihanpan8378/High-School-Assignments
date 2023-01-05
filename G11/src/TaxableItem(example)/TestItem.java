/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaxableItem;

import java.util.Scanner;

/**
 *
 * @author maanderson
 */
public class TestItem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of Cars you want to check: ");
        int num = input.nextInt();
        Item[] items = new Car[num];
        
        for (int i = 0; i < items.length; i++) {
            System.out.print("\n" + "\n" + "Enter brand name of car: ");
            String name = input.next();
            System.out.print("Enter Price:");
            double price = input.nextDouble();
            System.out.print("Enter Tax Rate: ");
            double tax = input.nextDouble();
            items[i] = new Car(name, price, tax);
        }
        for (Item item : items) {
            System.out.println("\n" + item);
        }

    }
}
