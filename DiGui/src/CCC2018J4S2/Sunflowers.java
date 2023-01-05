/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2018J4S2;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Sunflowers {

    public static int[][] bian(int[][] before) {
        int[][] after = new int[before.length][before.length];
        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after.length; j++) {
                after[i][j] = before[j][before.length - 1 - i];
            }
        }
        return after;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] before = new int[n][n];
        int[][] after = new int[n][n];

        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after.length; j++) {
                before[i][j] = in.nextInt();
            }
        }

        int smallest = before[0][0];
        int smallestI = 0, smallestJ = 0;
        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after.length; j++) {
                if (smallest > before[i][j]) {
                    smallest = before[i][j];
                    smallestI = i;
                    smallestJ = j;
                }
            }
        }

        int location;
        if (smallestI == 0 && smallestJ == 0) {
            location = 0;
        } else if (smallestI == 0 && smallestJ == before.length - 1) {
            after = bian(before);
            location = 1;
        } else if (smallestI == before.length - 1 && smallestJ == before.length - 1) {
            after = bian(bian(before));
            location = 2;
        } else if (smallestI == before.length - 1 && smallestJ == 0) {
            after = bian(bian(bian(before)));
            location = 3;
        } else {
            location = 999;
            System.out.println("cuole");
        }

        System.out.println("");
        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after.length; j++) {
                System.out.print(after[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
