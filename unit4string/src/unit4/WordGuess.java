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
public class WordGuess {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Word w = new Word();
        int i;
        i = 0;
        String a = ("-----");
        String b = " ";

        w.setWord(b);
        b = w.getWord();

        System.out.println("WordGuess game: ");
        System.out.println(a);

        do {
            System.out.print("Enter a letter (! to guess the word): ");
            String g = in.nextLine();
            w.setGuess(g);

            if (!w.getGuess().equals("!")) {
                if (b.contains(g)) {
                    String sub = a.substring(b.indexOf(g));
                    a = a.substring(0, b.indexOf(g)) + sub.replaceFirst("-", g);
                    System.out.println(a);
                } else {
                    System.out.println(a);
                }
            } else {
                System.out.println("Enter the word: ");
                String f = in.nextLine();
                w.setFinal(f);
                if (w.getFinal().equals(b)) {
                    System.out.println("You are right.");
                } else {
                    System.out.println("You are wrong.");
                }
            }
            i++;
        } while (!w.getGuess().equals("!"));
        System.out.print("The secret word is " + b);
        System.out.print("You made " + i + "guesses!");

    }
}
