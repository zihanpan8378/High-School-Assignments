/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class TwoDArray {

    public static void main(String[] args) {
        int[][] nums = new int[3][4];
        int[] sumColumn = new int[nums[0].length];
        int[] sumRow = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                int random = (int) (Math.random() * 10 + 1);
                nums[i][j] = random;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < sumColumn.length; j++) {
                System.out.print(nums[i][j] + "\t");
                sumRow[i] += nums[i][j];
                sumColumn[j] += nums[i][j];
            }
            System.out.println(sumRow[i]);
        }
        
        for (int j = 0; j < sumColumn.length; j++) {
            System.out.print(sumColumn[j] + "\t");
        }

        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print("Enter a number at" 
                        + " row " + (i + 1) 
                        + " column " + (j + 1) + ": ");
                int n = in.nextInt();
                nums[i][j] = n;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }*/
    }
}
