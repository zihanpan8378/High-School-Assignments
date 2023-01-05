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
public class TestRectangle {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        rectangle r = new rectangle();
        rectangle k = new rectangle();
       
        
        System.out.print("Enter length: ");
        double le = in.nextDouble();
        r.setLength(le);
        
        System.out.print("Enter width: ");
        le = in.nextDouble();
        r.setWidth(le);
        
        
        System.out.println("Area " + r.getArea());
        
        System.out.println("Perimeter" + r.getPerimeter());
        
    }
}
