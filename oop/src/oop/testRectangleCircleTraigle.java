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
public class testRectangleCircleTraigle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        rectangle r = new rectangle();
        circle k = new circle();
        triangle h = new triangle();
    
     
     System.out.println("1 = rectangle");
     System.out.println("2 = circle");
     System.out.println("3 = triangle");
     System.out.print("Enter shape:");
        double le = in.nextDouble();{
        
        if(le==1)
        {System.out.print("Enter length:");
        le = in.nextDouble();
        r.setLength(le);
        System.out.print("Enter width:");
        le = in.nextDouble();
        r.setWidth(le);
        
        System.out.println("Area " + r.getArea());
        System.out.println("Perimeter" + r.getPerimeter());
        }
        
        if(le==2)
        {System.out.print("Enter Radiu:");
        le = in.nextDouble();
        k.setRadiu(le);
        
        System.out.println("Area " + k.getArea());
        System.out.println("Perimeter" + k.getPerimeter());
        }
        
        if(le==3){
        System.out.print("Enter A:");
        le = in.nextDouble();
        h.setA(le);
        System.out.print("Enter B:");
        le = in.nextDouble();
        h.setB(le);
        System.out.print("Enter C:");
        le = in.nextDouble();
        h.setC(le); 
        
        System.out.println("Area " + h.getArea());
        System.out.println("Perimeter" + h.getPerimeter());
        }
    }
}
}
        
   

    
