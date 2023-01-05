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
public class ChooseYourOwnPath {

    static boolean[] b;
    static int[][] p;
    static int[] shortest;
    static int shortpath;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        b = new boolean[n + 1];
        shortest = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = false;
            shortest[i] = n + 1;
        }
        shortpath = n + 1;
        p = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            p[i][0] = input.nextInt();
            for (int j = 1; j <= p[i][0]; j++) {
                p[i][j] = input.nextInt();
            }
        }
        search(1, 0);
        boolean c = true;
        for (int i = 1; i <= n; i++) {
            if (!b[i]) {
                c = false;
            }
        }
        if (c) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        System.out.println(shortpath);

    }

    static void search(int page, int path) {
        if (path+1<shortest[page]) {
            shortest[page]=path+1;
            b[page] = true;
            int path1 = path + 1;
            if (p[page][0] == 0) {
                if (path1 < shortpath) {
                    shortpath = path1;
                }
            } else {
                for (int i = 1; i <= p[page][0]; i++) {
                    search(p[page][i], path1);
                }
            }
        }
    }
}