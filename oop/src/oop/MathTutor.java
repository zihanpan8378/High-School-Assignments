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
public class MathTutor {

    public static void main(String[] args) {
        //declare object scanner and random and variables
        Scanner in = new Scanner(System.in);
        Compval c1 = new Compval();
        Compval c2 = new Compval();

        int symbol = 0 + (int) (Math.random() * 3);
        int answer = 233;
        int times = 0;
        int corrects = 0;

        do{
        System.out.println("1 - Play");
        System.out.println("0 - Quit");
        System.out.println("Enter your choice:");
        int c = in.nextInt();
        c1.setChoice(c);

        if (c1.getChoice() == 1) {
            times++;
            if (symbol == 0) {
                c1.setNum();
                c2.setNum();
                System.out.println("What is " + c1.getNum() + " + " + c2.getNum());
                answer = c1.getNum() + c2.getNum();
            }
            if (symbol == 1) {
                c1.setNum();
                c2.setNum();
                System.out.println("What is " + c1.getNum() + " - " + c2.getNum());
                answer = c1.getNum() - c2.getNum();
            }
            if (symbol == 2) {
                c1.setNum();
                c2.setNum();
                System.out.println("What is " + c1.getNum() + " * " + c2.getNum());
                answer = c1.getNum() * c2.getNum();
            }
            if (symbol == 3) {
                c1.setNum();
                c2.setNum();
                System.out.println("What is " + c1.getNum() + " / " + c2.getNum());
                answer = c1.getNum() / c2.getNum();
            }

            int a = in.nextInt();
            c2.setChoice(a);

            if (c2.getChoice() == answer) {
                System.out.println("Correct!");
                corrects++;
            }
            if (c2.getChoice() != answer) {
                System.out.println("Incorrect!");
            }
        } 
        }while(c1.getChoice() == 1);
        
            System.out.println("Score " + corrects + " out " + times);
            System.out.println("Thank you for playing…");

        
    }
}
