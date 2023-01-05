/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circle;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("--------Circle---------");
        Circle c = new Circle(1.5);
        System.out.println("circle " + c);
        
        System.out.println("--------Disk---------");
        Disk d = new Disk(1, 1.5);
        System.out.println("disk " + d);
        
        System.out.println("--------Puck---------");
        Puck p = new Puck(5.2333, 1, 1.5);
        System.out.println("puck " + p);
        
        
        /*System.out.println("Enter the radiu: ");
        double radius = input.nextDouble();
        
        System.out.println("Enter the tickness: ");
        double tickness = input.nextDouble();
        
        System.out.println("Enter the weight: ");
        double weight = input.nextDouble();
        
        Puck c = new Puck(weight, tickness, radius);
        System.out.println(c.toString());*/
        
    }
    
}
