package Practise;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author localuser
 */
public class Sunflowers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int a[][] = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                a[i][j] = input.nextInt();
            }
        }
        int r = 0;
        if (a[0][0] <= a[0][1] && a[0][0] < a[1][0]) {
            r = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < x; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println("");
            }
        } else if (a[0][x - 1] <= a[0][x - 2] && a[0][x - 1] < a[1][x - 1]) {
            r = 1;
            for (int i = x - 1; i >= 0; i--) {
                for (int j = 0; j < x; j++) {
                    System.out.print(a[j][i] + " ");
                }
                System.out.println("");
            }
        } else if (a[x - 1][x - 1] <= a[x - 1][x - 2] && a[x - 1][x - 1] < a[x - 2][x - 1]) {
            r = 2;
            for (int i = x - 1; i >= 0; i--) {
                for (int j = x - 1; j >= 0; j--) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println("");
            }
        } else if (a[x - 1][0] <= a[x - 1][1] && a[x - 1][0] < a[x - 2][0]) {
            r = 3;
            for (int i = 0; i < x; i++) {
                for (int j = x - 1; j >= 0; j--) {
                    System.out.print(a[j][i] + " ");
                }
                System.out.println("");
            }
        }
    }
}