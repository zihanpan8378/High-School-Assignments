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
public class testDate {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Date b = new Date();
        Date f = new Date();

    System.out.print("Enter your birth day: ");
    int bd = in.nextInt();
    b.setDay(bd);
    System.out.print("Enter your birth month: ");
    int bm = in.nextInt();
    b.setMonth(bm);
    System.out.print("Enter your birth year: ");
    int by = in.nextInt();
    b.setYear(by);
    
    System.out.print("Enter future day: ");
    int fd = in.nextInt();
    f.setDay(fd);
    System.out.print("Enter future month: ");
    int fm = in.nextInt();
    f.setMonth(fm);
    System.out.print("Enter future year: ");
    int fy = in.nextInt();
    f.setYear(fy);

    if ((f.getMonth() == 1) || (f.getMonth() == 3) ||
            (f.getMonth() == 5)||(f.getMonth() == 7)||
            (f.getMonth() == 8)||(f.getMonth() == 10)||
            (f.getMonth() == 12)){
        
    if (f.getDay()- b.getDay() >= 0){
        if (f.getMonth()- b.getMonth() >= 0){
            System.out.print("You will be " 
            + (f.getYear() - b.getYear()) + "years" + " "
            + (f.getMonth() - b.getMonth()) + "months" + " "
            + (f.getDay() - b.getDay())+ "days");
        }
        else {
            System.out.print("You will be " 
            + (f.getYear() - b.getYear() - 1) + "years" + " "
            + (12 - (b.getMonth() - f.getMonth())) + "months" + " "
            + (f.getDay() - b.getDay())+ "days");
        } 
        }
    if (f.getDay()- b.getDay() < 0){
        if (f.getMonth()- b.getMonth() - 1 >= 0){
            System.out.print("You will be " 
            + (f.getYear() - b.getYear()) + "years" + " "
            + (f.getMonth() - b.getMonth() - 1) + "months" + " "
            + (31 - (b.getDay() - c.getDay()))+ "days");
        }
        else {
            System.out.print("You will be " 
            + (f.getYear() - b.getYear() - 1) + "years" + " "
            + (12 - (b.getMonth() - f.getMonth()) - 1) + "months" + " "
            + (31 - (b.getDay() - f.getDay()) + "days"));
        } 
        }
    }
    if ((f.getMonth() == 4) || (f.getMonth() == 6) ||
            (f.getMonth() == 9)||(f.getMonth() == 11)){
        
    if (f.getDay()- b.getDay() >= 0){
        if (f.getMonth()- b.getMonth() >= 0){
            System.out.print("You will be " 
            + (f.getYear() - b.getYear()) + "years" + " "
            + (f.getMonth() - b.getMonth()) + "months" + " "
            + (f.getDay() - b.getDay())+ "days");
        }
        else {
            System.out.print("You will be " 
            + (f.getYear() - b.getYear() - 1) + "years" + " "
            + (12 - (b.getMonth() - f.getMonth())) + "months" + " "
            + (f.getDay() - b.getDay())+ "days");
        } 
        }
    if (f.getDay()- b.getDay() < 0){
        if (f.getMonth()- b.getMonth() - 1 >= 0){
            System.out.print("You will be " 
            + (f.getYear() - b.getYear()) + "years" + " "
            + (f.getMonth() - b.getMonth() - 1) + "months" + " "
            + (30 - (b.getDay() - f.getDay()))+ "days");
        }
        else {
            System.out.print("You will be " 
            + (f.getYear() - b.getYear() - 1) + "years" + " "
            + (12 - (b.getMonth() - f.getMonth()) - 1) + "months" + " "
            + (30 - (b.getDay() - f.getDay()) + "days"));
        } 
        }
    }
    if ((f.getMonth() == 2)){
        
    if (f.getDay()- b.getDay() >= 0){
        if (f.getMonth()- b.getMonth() >= 0){
            System.out.print("You will be " 
            + (f.getYear() - b.getYear()) + "years" + " "
            + (f.getMonth() - b.getMonth()) + "months" + " "
            + (f.getDay() - b.getDay())+ "days");
        }
        else {
            System.out.print("You will be " 
            + (f.getYear() - b.getYear() - 1) + "years" + " "
            + (12 - (b.getMonth() - f.getMonth())) + "months" + " "
            + (f.getDay() - b.getDay())+ "days");
        } 
        }
    if (f.getDay()- b.getDay() < 0){
        if (f.getMonth()- b.getMonth() - 1 >= 0){
            System.out.print("You will be " 
            + (f.getYear() - b.getYear()) + "years" + " "
            + (f.getMonth() - b.getMonth() - 1) + "months" + " "
            + (28 - (b.getDay() - f.getDay()))+ "days");
        }
        else {
            System.out.print("You will be " 
            + (f.getYear() - b.getYear() - 1) + "years" + " "
            + (12 - (b.getMonth() - f.getMonth()) - 1) + "months" + " "
            + (28 - (b.getDay() - f.getDay()) + "days"));
        } 
        }
    }
        
    
    
    
    
    
    
    
}
}
