/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2019S2;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        int[] num = new int[line];

        for (int i = 0; i < line; i++) {
            num[i] = in.nextInt();
        }
        System.out.println("");
        int[] average1 = new int[line], average2 = new int[line];
        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < 9999999; j++) {
                average1[i] = num[i] + j;
                average2[i] = num[i] - j;
                int k;
                for (k = 2; k < 999; k++) {
                    if (average1[i] % k == 0 && average1[i] != k) {
                        break;
                    }
                    if (average2[i] % k == 0 && average2[i] != k) {
                        break;
                    }
                }
                if (k >= 999) {
                    System.out.println(average1[i] + " " + average2[i]);
                    break;
                }
            }
        }

    }
}
