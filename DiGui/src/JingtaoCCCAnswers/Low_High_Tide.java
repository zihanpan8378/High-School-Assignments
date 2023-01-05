/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practise;

import java.util.Scanner;

/**
 *
 * @author 40474
 */
public class Low_High_Tide {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for (int i = n - 1; i > 0; i -= 2) {
            int s = i - 1;
            int b = i;
            for (int j = i; j >= 0; j--) {
                if (a[j] > a[b]) {
                    b = j;
                }
            }
            int temp = a[i];
            a[i] = a[b];
            a[b] = temp;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[s]) {
                    s = j;
                }
            }
            temp = a[i - 1];
            a[i - 1] = a[s];
            a[s] = temp;
            
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");

    }
}
