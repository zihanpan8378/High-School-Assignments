/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CCC2020PracticeS1;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }

        int sa = 0, sb = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sa += a[i];
            sb += b[i];
            if (sa == sb) {
                count = i + 1;
            }
        }
        System.out.println(count);
    }
}
