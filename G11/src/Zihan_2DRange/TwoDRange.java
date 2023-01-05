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
public class TwoDRange {

    int[][] table;
    boolean[] filled;
    int filledRows = 0;
    Scanner in = new Scanner(System.in);

    TwoDRange() {
        System.out.print("Create your 2D table"
                + "\nEnter number of rows: ");
        int rows = in.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = in.nextInt();
        table = new int[rows][columns];
        filled = new boolean[rows];
    }

    public void fill2DArray(int row, NumberRange nr) {
        if (row >= table.length) {
            System.out.println("row index NOT available!");
        } else if (filled[row] == true) {
            System.out.println("row already filled!");
        } else {
            int[] nums = nr.range;
            for (int i = 0; i < table[row].length; i++) {
                if (nums.length > i) {
                    table[row][i] = nums[i];
                }
            }
            filled[row] = true;
            filledRows++;
            printArray(table);
        }
    }

    public boolean checkIfFull() {
        printArray(table);
        if (filledRows == filled.length) {
            System.out.println("Table is full!");
            return true;
        } else {
            System.out.println("Table is not full.");
            return false;
        }
    }

    public void printArray(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
    }

}

class test2DRange {

    public static void main(String[] args) {
        TwoDRange tr = new TwoDRange();
        tr.printArray(tr.table);
        tr.fill2DArray(2, new NumberRange(3, 5));
        tr.fill2DArray(3, new NumberRange(2, 9));
        tr.fill2DArray(0, new NumberRange(8, 4));
        System.out.println("");
        tr.printArray(tr.table);
    }
}
