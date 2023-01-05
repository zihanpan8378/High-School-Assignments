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
public class CoinTossGame {

    public static void main(String[] args) {
        //declare object scanner and random and variables
        Scanner in = new Scanner(System.in);
        CoinToss c = new CoinToss();

        double Totalpoints = 100;
        double Nowpoints = 100;
        int Result = 233;

        while (Nowpoints < 107) {
            int Heads = 0;
            int Tails = 0;
            System.out.println("Welcome to the Coin Toss!");
            System.out.println("You have " + Totalpoints + "points");
            System.out.println("How many times do you want to toss a coin?");
            int t = in.nextInt();
            c.setTimes(t);

            System.out.println("What will there be more of?");

            System.out.println("1 - Heads");
            System.out.println("2 - Tails");
            System.out.println("3 - Equal");
            System.out.println("4 - Quit");
            int g = in.nextInt();
            c.setGuess(g);

            if (c.getGuess() == 4) {
                System.out.print("thank you.");
                Nowpoints = 233;
            }

            if (c.getGuess() != 4) {
                for (int i = 0; i < c.getTimes(); i++) {
                    c.setCoin();

                    if (c.getCoin() == 1) {
                        Heads++;
                        System.out.println("Head");
                    }
                    if (c.getCoin() == 2) {
                        Tails++;
                        System.out.println("Tail");
                    }
                }

                if (Heads > Tails) {

                    Result = 1;

                } else if (Heads < Tails) {

                    Result = 2;
                } else if (Heads == Tails) {

                    Result = 3;
                }

                if (Result == c.getGuess()) {
                    System.out.println("You were right!");
                    Totalpoints = Nowpoints + 1;
                }
                if (Result != c.getGuess()) {
                    System.out.println("You were wrong!");
                    Totalpoints = Nowpoints - 1;
                }

                Result = 233;
                Nowpoints = Totalpoints;
            }
        }

    }
}
