/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

/**
 *
 * @author 44869
 */
public class Rectangle extends Shape implements IsResizable, Comparable{

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    //user-defined method
    @Override
    public double getArea() {
        return length * width;
    }

    //user-defined method
    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "length=" + length + ", width=" + width + '}';
    }

    @Override
    public boolean isResizable() {
        return getArea()>0;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class testRectangle{
    public static void main(String[] args) {
        IsResizable ir = new Rectangle(12, 34);
        Shape shape = new Rectangle(4, 20);
        Rectangle rec = new Rectangle(2, 4);
        
        
        
    }
}
