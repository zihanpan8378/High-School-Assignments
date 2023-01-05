/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class LuckyNum {

    public static void main(String[] args) {
        //declare object scanner and random and variables
        Scanner in = new Scanner(System.in);
        RandomNum n = new RandomNum();

        int odds = 0;
        int luckys = 0;

        System.out.println("Welcome to the Lucky Number Finder!");
        System.out.print("How many numbers do you want to generate? ");
        int t = in.nextInt();
        n.setChoice(t);

        for (int i = 1; i <= n.getChoice(); i++) {

            n.setNum();

            if (n.getNum() % 3 == 0) {
                if (n.getNum() % 5 != 0) {
                    if (n.getNum() % 2 != 1) {
                        System.out.println("#" + i + " - " + n.getNum() + " that is only lucky.");
                        luckys++;
                    }
                    if (n.getNum() % 2 == 1) {
                        System.out.println("#" + i + " - " + n.getNum() + " that is lucky and odd.");
                        luckys++;
                        odds++;
                    }
                }
                if (n.getNum() % 5 == 0) {
                    if (n.getNum() % 2 != 1) {
                        System.out.println("#" + i + " - " + n.getNum() + " sorry, not luckey, not odd.");
                    }
                    if (n.getNum() % 2 == 1) {
                        System.out.println("#" + i + " - " + n.getNum() + " sorry, not luckey, only odd.");
                        odds++;
                    }
                }
            }
            if (n.getNum() % 3 != 0) {
                if (n.getNum() % 5 == 0) {
                    if (n.getNum() % 2 != 1) {
                        System.out.println("#" + i + " - " + n.getNum() + " that is only lucky.");
                        luckys++;
                    }
                    if (n.getNum() % 2 == 1) {
                        System.out.println("#" + i + " - " + n.getNum() + " that is lucky and odd.");
                        luckys++;
                        odds++;
                    }
                }
                if (n.getNum() % 5 != 0) {
                    if (n.getNum() % 2 != 1) {
                        System.out.println("#" + i + " - " + n.getNum() + " sorry, not luckey, not odd.");
                    }
                    if (n.getNum() % 2 == 1) {
                        System.out.println("#" + i + " - " + n.getNum() + " sorry, not luckey, only odd.");
                        odds++;
                    }
                }
            } 
        }

        System.out.println("Thanks for playing.");
        System.out.println("Total lucky numbers: " + luckys);
        System.out.println("Total odd numbers: " + odds);
    }
}
