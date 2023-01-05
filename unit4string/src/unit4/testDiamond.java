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
public class testDiamond {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Diamond d = new Diamond();

        System.out.println("Enter your word: ");
        String w = in.nextLine();
        d.setWord(w);

        String r;
        if (d.getWord().length() <= 9) {
            r = d.getWord();
        } else {
            r = d.getWord().substring(0, 10);
        }
        int q, i, o, p;
        String b, c, f, g;
        g = "";
        f = "";
        c = "";
        q = 0;

        //for (q = 0; q <= a.length(); q++) {
        if (q == 0) {
            do {
                String a = r.substring(0, q + 1);

                for (i = 0; i <= q; i++) {
                    b = a.substring(a.length() - i - 1, a.length() - i);
                    c += b;

                }
                for (o = r.length(); o >= q; o--) {
                    g += " ";
                }
                f += g + a.substring(0, q) + c + "\n";
                String F = f.toUpperCase();
                System.out.print(F);
                q++;
                f = "";
                F = "";
                c = "";
                g = "";
            } while (q < r.length() - 1);
        }
        if (q == r.length() - 1) {
            do {
                String a = r.substring(0, q + 1);
                for (i = 0; i <= q; i++) {
                    b = a.substring(a.length() - i - 1, a.length() - i);
                    c += b;

                }

                for (p = a.length(); p <= r.length() + 1; p++) {
                    g += " ";
                }
                f += g + a.substring(0, q) + c + "\n";
                String F = f.toUpperCase();
                System.out.print(F);
                q--;
                f = "";
                F = "";
                c = "";
                g = "";
            } while (q >= 0);
        }
    }

}
