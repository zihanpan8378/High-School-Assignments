/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beginner;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class NewClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 4;
        int[][] num = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                num[i][j] = in.nextInt();
            }
        }
        
        int[][] sum = new int[2][4];
        for (int i = 0; i < sum.length; i++) {
            int[] is = sum[i];
            
        }
        
    }
}
