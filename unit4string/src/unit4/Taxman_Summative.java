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
public class Taxman_Summative {

    int range, totalFactor = 0, enter, user = 0, tax = 0;
    int[] numbers;
    String name;
    Scanner input = new Scanner(System.in);

    public void setRange() {
        System.out.println("Welcome - can you make more than the taxman? ");
        System.out.print("What is your name? ");
        name = input.nextLine();
        System.out.print("\n" + name + ", please enter a number for range: ");
        range = input.nextInt();
        numbers = new int[range + 1];
        for (int i = 0; i < range + 1; i++) {
            numbers[i] = 1;
        }
    }//let the user set the range and make a array, each place of the array can compare with a number in the range, 
    //all place are 1 in the array now, which shows that each number in the range are not used.

    public void setEnter() {
        totalFactor = 0;
        System.out.print("\n" + name + ", please enter a number between 1 and " + range + " :");
        enter = input.nextInt();
        while (numbers[enter] == 0) {
            System.out.print("The number is no longer in play now, please enter again.");
            enter = input.nextInt();
        }
        numbers[enter] = 0;
        System.out.print("\n" + "You entered: " + enter);
    }//let the user enter a number, and the compared place become 0.

    public int[] getFactors() {
        int a = 0;
        int[] factors = new int[enter];
        for (int i = 1; i <= enter + 1; i++) {
            if (enter % i == 0) {
                factors[a] = i;
                a++;
            }
        }
        return factors;
    }//get all possible factors of the entered number.

    public int getTotalFactor() {
        int[] f = getFactors();
        for (int i = 0; i < f.length; i++) {
            if (numbers[f[i]] == 1 && f[i] != 0) {
                totalFactor += f[i];
            }
        }
        return totalFactor;
    }//get the available factors and the sum of them.

    public void setPrintFactors() {
        int[] f = getFactors();
        System.out.print("\n" + "The taxman gets: ");
        for (int i = 0; i < f.length; i++) {
            if (numbers[f[i]] == 1 && f[i] != 0) {
                numbers[f[i]] = 0;
                System.out.print(f[i] + " ");
            }
        }
        System.out.println("\n" + "the sum or factors is: " + totalFactor);
    }//print available factors.

    public int getUserScore() {
        user += enter;
        return user;
    }//count user's score.

    public int getTax() {
        tax += totalFactor;
        return tax;
    }//count taxman's score

    public String getResult() {
        String result;
        if (enter > totalFactor) {
            result = "You won this round.";
        } else if (totalFactor > enter) {
            result = "The taxman won this round.";
        } else {
            result = "You are equal this round.";
        }
        return result;
    }//print the result (who won) of this round.

    public void setFinish() {
        System.out.print("\n" + "The factor of " + enter + "( ");
        //user += enter;
        tax += enter;
        for (int i = 0; i < getFactors().length; i++) {
            if (getFactors()[i] != 0) {
                System.out.print(getFactors()[i] + " ");
            }
        }
        System.out.println(") are no longer in play. The taxman takes all remaining numbers.");
        for (int i = 1; i <= range; i++) {
            if (numbers[i] == 1) {
                tax += i;
            }
        }
        System.out.println("\n" + "You score: " + user);
        System.out.println("Taxman score: " + tax);
    }//if there is no available number in the array, do the last round.

    public void setFinalResult() {
        String result;
        if (user > tax) {
            result = "You win this game.";
        } else if (tax > user) {
            result = "The taxman win this game.";
        } else {
            result = "You are equal in this game.";
        }
        System.out.println(result);
    }//get the final result(who win the game) of the game.

}
