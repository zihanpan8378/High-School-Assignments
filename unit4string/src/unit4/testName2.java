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
public class testName2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Name2 n = new Name2();
        int i;
        int r;

        System.out.println("Enter your full name.");
        String full = in.nextLine();
        n.setFullname(full);

        System.out.println("Enter your size.");
        int s = in.nextInt();
        n.setSize(s);

        for (r = 0; r < n.getSize(); r++) {

            for (i = n.getFirstname().length(); i >= 0; i--) {
                if (i != 1) {
                    System.out.println(n.getFirstname().substring(0, i).toUpperCase());
                }
                if (i == 1) {
                    do {
                        System.out.println(n.getFirstname().substring(0, i).toUpperCase());
                        i++;
                    } while (i <= n.getFirstname().length());
                    i = -1;

                }
            }

            for (i = n.getLastname().length(); i >= 0; i--) {
                if (i != 2) {
                    System.out.println(n.getLastname().substring(0, i).toUpperCase());
                }
                if (i == 2) {
                    do {
                        System.out.println(n.getLastname().substring(0, i).toUpperCase());
                        i++;
                    } while (i <= n.getLastname().length());
                    i = -1;

                }
            }

        }

    }
}
