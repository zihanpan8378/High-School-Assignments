/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxdemo;

/**
 *
 * @author 44869
 */
public class Rectangle {

    int length;
    int width;

    public Rectangle() {

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return (length * 2 + width * 2);
    }

    @Override
    public String toString() {
        return "Rectangle{" + "length=" + length + ", width=" + width + '}';
    }

}
