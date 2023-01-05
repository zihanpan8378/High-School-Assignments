/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practise;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 40474
 */
public class NailedIt {

    static int[] b;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int c = 0;
        b = new int[n * (n - 1) / 2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                b[c] = a[i] + a[j];
                c++;
            }
        }
        Arrays.sort(b);
        int x = 0;
        int y = 1;
        int max = 1;
        int length = 0;
        while (x + 1 < b.length) {
            int z = 1;
            while (x + 1 < b.length && b[x] == b[x + 1]) {
                z++;
                x++;
            }
            if (z >= max) {
                if (z == max) {
                    y++;
                } else {
                    max = z;
                    y = 1;
                }
            }
            x++;
        }
        System.out.println(max + " " + y);
    }
}
