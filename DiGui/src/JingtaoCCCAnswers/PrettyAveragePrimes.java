/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 40474
 */
public class PrettyAveragePrimes {

    static ArrayList<Integer> al;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            if (a[i] > max) {
                max = a[i];
            }
        }
        max = max * 2;
        al = new ArrayList<>();
        for (int i = 2; i < max; i++) {
            if (isPrime(i)) {
                al.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            String m = f(a[i] * 2);
            if (!m.equals("-1")) {
                System.out.println(m);
            }
        }

    }

    public static boolean isPrime(int x) {
        boolean b = true;
        for (int i = 0; i < al.size(); i++) {
            if ((x % (al.get(i))) == 0) {
                return false;
            } else {
                if (al.get(i)>Math.sqrt(x)) {
                    return true;
                }
            }
        }
        return b;
    }

    public static String f(int x) {
        int i = 0;
        while (al.get(i) < (x / 2)) {
            int n = al.get(i);
            int m = x - n;
            if (al.indexOf(m) != -1) {
                return (n + " " + m + " ");
            }
            i++;
        }
        return ("-1");
    }
}

