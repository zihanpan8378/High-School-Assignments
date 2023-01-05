/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circle;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author 44869
 */
public class Circle {

    private double radius;
    NumberFormat nf = new DecimalFormat("0.00");

    public Circle(double r) {
        radius = r;
    }

    public Circle() {

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(getRadius(), 2) * Math.PI;
    }
    
    public double getCircumference(){
        return 2* Math.PI * getRadius();
    }

    @Override
    public String toString() {
        return "Radius: " + nf.format(getRadius()) 
                + "\nArea: " + nf.format(getArea())
                + "\nCircumference: " + nf.format(getCircumference());
    }
    
    
}
