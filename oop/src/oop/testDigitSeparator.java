/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Scanner;

/**
 *
 * @author 448692
 */
public class testDigitSeparator {

    public static void main(String[] args) {
        //declare object scanner and number and variables
        Scanner in = new Scanner(System.in);
        Number d = new Number();

        //declare variables
        String answer = "";

        do {
            //get input form the user
            System.out.print("Enter a four-digit integer: ");
            double n = in.nextDouble();
            d.setNum(n);

            //get choice from the user
            System.out.println("Show [0]Whole number");
            System.out.println("Show [1]Ones place number");
            System.out.println("Show [2]Tens place number");
            System.out.println("Show [3]Hundreds place number");
            System.out.println("Show [4]Thousands place number");
            System.out.println("Show [5]Total of all digits");
            System.out.println("[-1] To Quit");
            System.out.print("Enter your choice: ");
            int c = in.nextInt();
            d.setChoice(c);

            //give resule to user
            if (d.getChoice() == 0) {
                System.out.println("The whole number is: "
                        + d.getThousandsplacenumber() + d.getHundredsplacenumber()
                        + d.getTensplacenumber() + d.getOnesplacenumber());
            }
            if (d.getChoice() == 1) {
                System.out.println("The ones place digit is: " + d.getOnesplacenumber());
            }
            if (d.getChoice() == 2) {
                System.out.println("The tens place digit is: " + d.getTensplacenumber());
            }
            if (d.getChoice() == 3) {
                System.out.println("The hundreds place digit is: " + d.getHundredsplacenumber());
            }
            if (d.getChoice() == 4) {
                System.out.println("The thousands place digit is: " + d.getThousandsplacenumber());
            }
            if (d.getChoice() == 5) {
                System.out.println("The total of all digits is: " + d.getTotalofalldigits());
            }
            if (d.getChoice() == -1) {
                System.out.println("Thank you...");
            }

            //ask user if they want to repeat
            System.out.println("Do you want to do this again? (Enter yes or no)");
            answer = in.next();

        } while (answer.equals("yes"));
    }

}
