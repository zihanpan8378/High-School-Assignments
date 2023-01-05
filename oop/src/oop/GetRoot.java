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
public class GetRoot {

    public static void main(String[] args) {
        //declare object scanner and random and variables
        Scanner in = new Scanner(System.in);
        QuadraticEquation e = new QuadraticEquation();
        String answer = "";
        
        do {
            System.out.print("Enter a: ");
            double a = in.nextDouble();
            e.setA(a);

            System.out.print("Enter b: ");
            double b = in.nextDouble();
            e.setB(b);

            System.out.print("Enter c: ");
            double c = in.nextDouble();
            e.setC(c);

            e.haveroot();
            e.root1();
            e.root2();
            System.out.println(e.showAnswer());

            System.out.print("Do you want to guess again? (say Yes or No) ");
            answer = in.next();

        } while (answer.equals("Yes"));
    }
}
