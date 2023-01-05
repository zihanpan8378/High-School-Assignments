/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2019J4S1;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class NewClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String flip = in.nextLine();
        int h = 0, v = 0;

        for (int i = 0; i < flip.length(); i++) {
            String a = flip.substring(i, i + 1);
            if (a.equals("H")) {
                h++;
            } else if (a.equals("V")) {
                v++;
            }
        }
        
        if (h % 2 != 0) {
            System.out.println("3 4\n1 2");
        }
        if (v % 2 != 0) {
            System.out.println("2 1\n4 3");
        }
        if (h % 2 != 0 && v % 2 != 0) {
            System.out.println("4 3\n2 1");
        }
    }
}
