/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zihan_2DRange;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {
        TwoDRange td = new TwoDRange();
        Scanner in = new Scanner(System.in);
        
        td.printArray(td.table);
        int choice = 0;
        do {
            System.out.print("\n1 - Fill table"
                    + "\n2 - Check if full"
                    + "\n0 - Quit"
                    + "\n>> ");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.print("Enter index row to fill in: ");
                int row = in.nextInt();
                System.out.print("Enter min: ");
                int min = in.nextInt();
                System.out.print("Enter max: ");
                int max = in.nextInt();
                td.fill2DArray(row, new NumberRange(min, max));
                /*if (td.filledRows == td.filled.length) {
                    System.out.println("Table is full!");
                    break;
                }*/
            } else if (choice == 0) {
                break;
            } else if (choice == 2) {
                boolean iffull = td.checkIfFull();
                if(iffull == true){
                    break;
                }
            } else {
                System.out.println("Wrong choice!");
            }
        } while (choice != 0);
        System.out.println("Thank you...");
        
        
        /*td.fill2DArray(0, new NumberRange(1, 10));
        td.fill2DArray(1, new NumberRange(2, 5));
        td.fill2DArray(5, new NumberRange(1, 2));
        td.fill2DArray(2, new NumberRange(3, 5));
        td.fill2DArray(3, new NumberRange(8, 9));
        td.fill2DArray(4, new NumberRange(1, 5));
        td.fill2DArray(7, new NumberRange(2, 5));
        
        System.out.println("printing...");
        td.printArray(td.table);        
        System.out.println(td.checkIfFull());*/
    }
}
