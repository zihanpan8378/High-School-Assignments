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
public class testCircle {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
        circle r = new circle();
        
        System.out.print("Enter radiu: ");
        double le = in.nextDouble();
        r.setRadiu(le);
    
        
        System.out.println("Area " + r.getArea());
        
        System.out.println("Perimeter" + r.getPerimeter());
    }
}
