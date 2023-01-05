/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParenthesesChecker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class ParenthesesChecker {

    String equation;
    ArrayList<Integer> left = new ArrayList(), right = new ArrayList();

    public void enter(String equation) {
        this.equation = equation;
    }

    public void check() {
        for (int i = 0; i < equation.length(); i++) {
            if (equation.substring(i, i + 1).equals(")")) {
                int j;
                for (j = i; j >= 0; j--) {
                    if (equation.substring(j, j + 1).equals("(")) {
                        left.add(j);
                        right.add(i);
                        equation = equation.substring(0, j) + " "
                                + equation.substring(j + 1, i) + " "
                                + equation.substring(i + 1);
                        break;
                    }
                }
                if (j < 0) {
                    System.out.println("so many rights!");
                }
            }
        }

    }

    public void print() {
        for (int i = 0; i < left.size(); i++) {
            System.out.println("Pair: " + right.get(i) + "\t" + left.get(i));
        }
        for (int i = 0; i < equation.length(); i++) {
            if (equation.substring(i, i + 1).equals("(")) {
                System.out.println("so many lefts!");
            }
        }
    }

}

class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ParenthesesChecker p = new ParenthesesChecker();

        System.out.println("Enter an equatoin: ");
        String equation = in.next();
        p.enter(equation);
        p.check();
        p.print();
    }
}

 /*class ParenthesesCheckerDemo{
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         String expression;
         System.out.println("Enter an expression: ");
         expression = input.nextLine();
         
         
     }
}*/
