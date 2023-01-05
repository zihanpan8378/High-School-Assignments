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
public class Guessinggame {

    public static void main(String[] args) {
        //declare object scanner and random and variables
        Scanner in = new Scanner(System.in);
        int n = 0;
        Compval c = new Compval();
        c.setNum();
        System.out.println("Hello!  Welcome to the number guessing game.") ;
        System.out.println("I’m thinking of a number between 1 and 10.  Try to guess the number.") ;
        String answer = "";

        do {
            System.out.print("Enter your guess: ");
            n = in.nextInt();
            

            if (n == c.getNum()) {
                System.out.println("Yes! You are correct. Congratulations!");
                System.out.println("Do you want to guess again?");
                answer = in.next();
            }
            if ((n != c.getNum())) {

                System.out.println("No sorry that is not the number!");
                System.out.println("Do you want to guess again?");
                answer = in.next();
            }
        } while (answer.equals("yes"));

    }
}
