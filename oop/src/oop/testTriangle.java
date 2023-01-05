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
public class testTriangle {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        triangle r = new triangle();
        
       
        
        System.out.print("Enter A: ");
        double le = in.nextDouble();
            r.setA(le);
        
        System.out.print("Enter B: ");
        le = in.nextDouble();
        r.setB(le);
        
        System.out.print("Enter C: ");
        le = in.nextDouble();
        r.setC(le);
        
        
        System.out.println("Area " + r.getArea());
        
        System.out.println("Perimeter" + r.getPerimeter());
        }
}
