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
public class testeggs {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        eggs r = new eggs();
    
    
     System.out.print("Enter eggs:");
        double le = in.nextDouble();
        r.setEggs(le);
        r.setDozen(le);
        r.setBaseprice(le);

        System.out.println("Price " + r.getPrice());
        }
}
