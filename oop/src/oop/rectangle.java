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
public class rectangle {
    double length;
    double width;
    
    public void setLength(double l) {
            length = l;
    }
    public double getLength() {
        return length;
    }
    public void setWidth(double w) {
            width = w;
    }
    public double getWidth() {
        return width;
    }
    public double getArea() {
        return width * length;
    }
    public double getPerimeter() {
        return 2*width + 2*length;
    }
}
