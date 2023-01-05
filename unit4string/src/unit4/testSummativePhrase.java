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
public class testSummativePhrase {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        SummativePhrase p = new SummativePhrase();

        System.out.println("Enter a phrase: ");
        String s = in.nextLine();
        p.setPhrase(s);

        System.out.println("Consonants: " + "\n" + p.getConsonants() + " = " + p.getConsonants().length());
        System.out.println("Voewls: " + "\n" + p.getVoels()  + " = " + p.getVoels().length());
        System.out.println("Numbers: " + "\n" + p.getNumbers()  + " = " + p.getNumbers().length());
        System.out.println(p.getLine());
    }
}
