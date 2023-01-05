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
public class QuadraticEquation {

    double a, b, c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public boolean haveroot() {
        if ((b * b - 4 * a * c) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public double root1() {
        return (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    }

    public double root2() {
        return (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    }

    public String showAnswer() {
        if (haveroot() == true) {
            return "The roots are: " + "\n" + "Root1 = " + root1() + "\n" + "Root2 = " + root2();
        } else {
            return "This quadratic equation doesn't have real root";
        }

    }

}
