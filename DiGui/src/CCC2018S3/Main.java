/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2018S3;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();

        String[][] factory = new String[row][column];
        for (int i = 0; i < factory.length; i++) {
            for (int j = 0; j < factory[0].length; j++) {
                factory[i][j] = in.nextLine();
            }
        }

        for (int i = 0; i < factory.length; i++) {
            for (int j = 0; j < factory[0].length; j++) {
                if (factory[i][j].equals(".")) {

                }
            }

        }
    }

    public int step(String[][] factory, int fx, int fy, int tx, int ty, int steps) {
        int distance = (tx - fx) + (ty - fy);
        String direction;
        steps++;
        if (distance == 1) {
            if (factory[tx][ty].equals(".")) {
                if ((tx - fx) == 1) {
                    direction = "R";
                } else if ((tx - fx) == -1) {
                    direction = "L";
                } else if ((ty - fy) == 1) {
                    direction = "D";
                } else if ((ty - fy) == -1) {
                    direction = "U";
                }
                return steps;
            }
        } else {
            if (factory[fx + 1][fy].equals(".")) {
                int a = step(factory, fx + 1, fy, tx, ty, steps);
                if (a != -1) {
                    steps += a;
                }
            }
            if (factory[fx - 1][fy].equals(".")) {
                int a = step(factory, fx - 1, fy, tx, ty, steps);
                if (a != -1) {
                    steps += a;
                }
            }
            if (factory[fx][fy + 1].equals(".")) {
                int a = step(factory, fx, fy + 1, tx, ty, steps);
                if (a != -1) {
                    steps += a;
                }
            }
            if (factory[fx][fy - 1].equals(".")) {
                int a = step(factory, fx, fy - 1, tx, ty, steps);
                if (a != -1) {
                    steps += a;
                }
            }
        }
        return steps;
    }
}
