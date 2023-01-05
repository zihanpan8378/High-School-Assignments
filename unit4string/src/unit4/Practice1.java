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
public class Practice1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i;
        int a=0;
        
        System.out.print("Enter a phrase: ");
        String s = in.nextLine();

        System.out.print("Enter a character to search: ");
        String w = in.next();
        for (i = 0; i < s.length(); i++) {
            if (s.substring(i, i+1).equals(w)) {
                a++;
            }
        }
        System.out.print("There are " + a + " "+w + "'s in " + s);
    }
}