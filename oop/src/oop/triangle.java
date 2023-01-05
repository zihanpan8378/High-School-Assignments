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
public class triangle {
    double A;
    double B;
    double C;
    
    public void setA(double a) {
            A = a;
    }
    public double getA() {
        return A;
    }
    public void setB(double b) {
            B = b;
    }
    public double getB() {
        return B;
    }
    public void setC(double c) {
            C = c;
    }
    public double getC() {
        return C;
    }
    public double getPerimeter() {
        return A + B + C;
    }
    public double getArea() {
        return Math.sqrt(((A + B + C) * 0.5) * ((A + B + C) *0.5 - A) * ((A + B + C) * 0.5 - B) * ((A + B + C) * 0.5 - C));
    }
}
