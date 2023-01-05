/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2018J3;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class AreWeThereYet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] city = new int[5];
        city[0] = 0;
        for (int i = 1; i < city.length; i++) {
            city[i] = in.nextInt();
        }
        int[][] distances = new int[5][5];

        for (int i = 0; i < city.length; i++) {
            for (int j = 1; j <= i; j++) {
                distances[0][i] += city[j];
            }
        }
        for (int i = 1; i < distances.length; i++) {
            for (int j = 0; j < distances[i].length; j++) {
                distances[i][j] = distances[i - 1][j] - city[i];
            }
        }
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances.length; j++) {
                System.out.print(Math.abs(distances[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
