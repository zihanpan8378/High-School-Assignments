/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class NailedIt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int length = in.nextInt();

        int[] wood = new int[length];

        for (int i = 0; i < wood.length; i++) {
            wood[i] = in.nextInt();
        }
        int fenceL = 0;
        int[][] fenceH = new int[length][length];
        for (int i = 0; i < wood.length; i++) {
            for (int j = i + 1; j < wood.length; j++) {
                fenceH[i][j] = wood[i] + wood[j];
            }
        }

        int[][] fenceS = new int[length][length];
        for (int i = 0; i < fenceH.length; i++) {
            for (int j = 0; j < fenceH.length; j++) {
                for (int k = 0; k < fenceH.length; k++) {
                    for (int l = 0; l < fenceH.length; l++) {
                        if (fenceH[i][j] == fenceH[k][l] && fenceH[i][j] != 0 && i != k && j != l) {
                            fenceS[i][j]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < fenceH.length; i++) {
            System.out.println("");
            for (int j = 0; j < fenceH.length; j++) {
                System.out.print(fenceH[i][j] + " ");
            }
        }
        System.out.println("\n\n\n");
        for (int i = 0; i < fenceS.length; i++) {
            System.out.println("");
            for (int j = 0; j < fenceS.length; j++) {
                System.out.print(fenceS[i][j] + " ");
            }
        }

        int count = 0;
        int longest = 0;
        for (int i = 0; i < fenceS.length; i++) {
            for (int j = 0; j < fenceS.length; j++) {
                if (fenceS[i][j] >= longest) {
                    longest = fenceS[i][j];
                }
            }
        }
        for (int i = 0; i < fenceS.length; i++) {
            for (int j = 0; j < fenceS.length; j++) {
                if (fenceS[i][j] == longest) {

                }
            }
        }

        System.out.println("\n\n\n");
        for (int i = 0; i < fenceS.length; i++) {
            System.out.println("");
            for (int j = 0; j < fenceS.length; j++) {
                System.out.print(fenceS[i][j] + " ");
            }
        }

        System.out.println("\n\n\n\n\n" + (longest + 1) + " " + (count / 2));


        /*
        01 02 03 04 05
           12 13 14 15
              23 24 25
                 34 35
                    45
         */
 /*int count = 0;
        int[] fenceH2 = new int[length * length];
        int fInt = 0;
        for (int i = 0; i < fenceH.length; i++) {
            for (int j = i + 1; j < fenceH.length; j++) {
                fenceH2[fInt] = fenceH[i][j];
                fInt++;
            }
        }
        for (int i = 0; i < fenceH2.length; i++) {
            for (int j = i + 1; j < fenceH2.length; j++) {
                if (fenceH2[i] == fenceH2[j]) {
                    fenceH2[j] = 0;
                }
            }
        }
        for (int i = 0; i < fenceH2.length; i++) {
            if (fenceH2[i] != 0) {
                count++;
            }
        }
        System.out.println(count);
         */
    }
}
