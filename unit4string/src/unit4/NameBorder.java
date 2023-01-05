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
public class NameBorder {
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("Parent 1 first name?");
        String n1 = in.nextLine();
       
        
        System.out.println("Parent 2 first name?");
        String n2 = in.nextLine();
        
        System.out.println("Child Gender?");
        String g = in.nextLine();
        if (g.equalsIgnoreCase("female") == true){
            System.out.println("Suggested baby name: " + 
                    (n2.substring(0,2)).toUpperCase()  + 
                    (n1.substring(0,4)).toUpperCase());
        }
        if (g.equalsIgnoreCase("female") == false){
            System.out.println("Suggested baby name: " + 
                    (n1.substring(0,4)).toUpperCase()  + 
                    (n2.substring(0,2)).toUpperCase());
        }
        
        
        
    }
}
