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
public class equation {
    
  double a;
  double b;
  double c;  

public void seta(double aa) {
          a = aa;
    }
public void setb(double bb) {
          b = bb;
    }
public void setc(double cc) {
          c = cc;
    }
public double getroot1() {
    return  (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a); 
          
    
}
public double getroot2() {
    return  (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a); 
}
}
