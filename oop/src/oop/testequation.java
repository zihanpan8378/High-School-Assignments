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
public class testequation {
    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
        equation r = new equation();
    
        
     System.out.print ("Enter a:");
        double le = in.nextDouble();
        r.seta(le);
        
        System.out.print ("Enter b:");
         le = in.nextDouble();
        r.setb(le);
        
        System.out.print ("Enter c:");
         le = in.nextDouble();
        r.setc(le);
        
        
        System.out.print("Root " + r.getroot1());
        
        System.out.print(  " and "  );
        
        System.out.print(+ r.getroot2());
            }
    }
