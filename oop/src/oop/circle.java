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
public class circle {
    double radiu;
    public void setRadiu(double r) {
          radiu = r;
    }
    public double getArea() {
        return radiu * radiu * Math.PI;
    }
    public double getPerimeter() {
        return radiu * 2 * Math.PI;
    }
}
