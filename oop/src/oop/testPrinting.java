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
public class testPrinting {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Printing r = new Printing();
    
    
     System.out.print("Enter Copies:");
        int le = in.nextInt();
        r.setCopies(le);
        
        System.out.println("Price " + r.getPrice());
        }
}
       
