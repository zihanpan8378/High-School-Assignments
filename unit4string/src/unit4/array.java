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
public class array {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String[] roster;
        
       System.out.print("How many students in the class: ");
        int numStudents = in.nextInt();
        
        roster = new String[numStudents];
        System.out.println(roster);
        
        for (int i = 0; i<roster.length; i++){
            System.out.println("Enter name #" + (i+1));
            String name = in.next();
            roster[i] = name;
        }
        
        System.out.print(roster[0]);
        for (int i = 1; i<roster.length; i++){
           
            System.out.print(", " + roster[i]);
        }
        
        }
}
