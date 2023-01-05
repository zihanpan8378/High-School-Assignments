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
public class testFitness {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Fitness f = new Fitness();

        System.out.println("Which measurement do you want to use?");
        System.out.println("1 - BMI");
        System.out.println("2 - Waist to Height Ratio");
        System.out.print("Enter your choice:");
        int mea = in.nextInt();
        f.setChoice(mea);

        if (f.getChoice() == 1) {
            System.out.print("Enter weight in kilograms:");
            int we = in.nextInt();
            f.setWeight(we);
            System.out.print("Enter height in meters:");
            double me = in.nextDouble();
            f.setHeight(me);
            System.out.println("Your BMI:" + f.getBMI());

            if (f.getBMI() < 18.5) {
                System.out.println("You are: Underweight");
            }
            if ((18.5 <= f.getBMI()) && (f.getBMI() < +25)) {
                System.out.println("You are: Normal weight");
            }
            if ((25 < f.getBMI()) && (f.getBMI() < 30)) {
                System.out.println("You are: Overweight");
            }
            if (f.getBMI() >= 30) {
                System.out.println("You are: Obese");
            }
        }
        if (f.getChoice() == 2) {
            System.out.print("Enter waist circumference in cm:");
            int wa = in.nextInt();
            f.setWaist(wa);
            System.out.print("Enter height in meters:");
            double me = in.nextDouble();
            f.setHeight(me);

            System.out.println("Are you female or male?");
            System.out.println("1= female");
            System.out.println("2= male");
            System.out.print("Enter your gender:");
            int gen = in.nextInt();
            f.setChoice(gen);

            System.out.println("Your ratio is:" + f.getRatio());
            if (f.getChoice() == 1) {
                if (f.getRatio() < 0.8) {
                    System.out.println("You are: Normal weight");
                }
                if ((f.getRatio() >= 0.8) && (f.getRatio() <= 0.84)) {
                    System.out.println("You are: Overweight");
                }
                if (f.getRatio() >= 0.85) {
                    System.out.println("You are: Obese");
                }
            }
            if (f.getChoice() == 2) {
                if (f.getRatio() < 0.9) {
                    System.out.println("You are: Normal weight");
                }
                if ((f.getRatio() >= 0.9) && (f.getRatio() <= 0.99)) {
                    System.out.println("You are: Overweight");
                }
                if (f.getRatio() >= 1) {
                    System.out.println("You are: Obese");
                }
            }

        }

    }
}
