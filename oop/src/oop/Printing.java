/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author 44869
 */
public class Printing {
    double copies;
    
    public void setCopies(double c) {
          copies = c;
    }
    public double getPrice() {
       if(copies<=99)
        return 0.25 * copies;
       
       else if(copies<=499 && copies>=100)
        return 0.26 * copies;
       
       else if(copies<=749 && copies>=500)
        return 0.27 * copies;
       
       else if(copies<=1000 && copies>=750)
        return 0.28 * copies;
       
       else if(copies>1000)
        return 0.29 * copies;
        
        return 0;
       }  
    }