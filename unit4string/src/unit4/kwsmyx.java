/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class kwsmyx {

    public static void main(String[] args) {
        int n;

        String[][] xb = new String[22][22];
        Scanner in = new Scanner(System.in);

        System.out.println("Enter k: ");
        n = in.nextInt();

        int[] x = new int[n], y = new int[n];

        String[][] change = new String[21][21];
        for (int ix = 0; ix < 21; ix++) {
            for (int iy = 0; iy < 21; iy++) {
                xb[ix][iy] = "s";
                change[ix][iy] = xb[ix][iy];
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.println("k" + (i + 1));
            System.out.println("Coordinate x: ");
            x[i] = in.nextInt();
            System.out.println("Coordinate y: ");
            y[i] = in.nextInt();
            change[x[i]][y[i]] = "h";
        }

        for (int ix = 1; ix < 21; ix++) {
            for (int iy = 1; iy < 21; iy++) {
                xb[ix][iy] = change[ix][iy];
                System.out.print(xb[ix][iy]);
            }
            System.out.println("");

        }
        String ask = "";
        System.out.println("Next? (y or n) ");
        ask = in.nextLine();
        int live;
        int jixu = 0;
        do {
            jixu = 0;
            for (int ix = 1; ix < 21; ix++) {
                for (int iy = 1; iy < 21; iy++) {
                    live = 0;
                    if ("h".equals(xb[ix - 1][iy + 1])) {
                        live++;
                    }
                    if ("h".equals(xb[ix][iy + 1])) {
                        live++;
                    }
                    if ("h".equals(xb[ix + 1][iy + 1])) {
                        live++;
                    }
                    if ("h".equals(xb[ix - 1][iy])) {
                        live++;
                    }
                    if ("h".equals(xb[ix + 1][iy])) {
                        live++;
                    }
                    if ("h".equals(xb[ix - 1][iy - 1])) {
                        live++;
                    }
                    if ("h".equals(xb[ix][iy - 1])) {
                        live++;
                    }
                    if ("h".equals(xb[ix + 1][iy - 1])) {
                        live++;
                    }

                    if (live < 2) {
                        change[ix][iy] = "s";
                    }
                    if (live == 2) {
                        change[ix][iy] = xb[ix][iy];
                    }
                    if (live > 3) {
                        change[ix][iy] = "s";
                    }
                    if (live == 3) {
                        change[ix][iy] = "h";
                    }
                }

            }

            for (int ix = 1; ix < 21; ix++) {
                for (int iy = 1; iy < 21; iy++) {
                    xb[ix][iy] = change[ix][iy];
                    System.out.print(xb[ix][iy]);
                }
                System.out.println("");

            }
            
            for (int ix = 1; ix < 21; ix++) {
                for (int iy = 1; iy < 21; iy++) {
                    if (xb[ix][iy].equals("h")){
                        jixu++;
                    } 
                }
            }
            
            System.out.println("Next? (y or n) ");
            ask = in.nextLine();
        } while (ask.equals("y")&&jixu > 0); 
        
        System.out.println("Game over");

    }
}
