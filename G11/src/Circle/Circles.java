/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circle;

/**
 *
 * @author 44869
 */
public class Circles {

    Circle[] c;
    int count = 0;
    int length;

    /*public Circles(int length){
        this.length = length;
        c = new Circle(this.length);
    }*/
    public void addCircle(Circle circle) {
        if (count < c.length) {
            c[count] = circle;
            count++;
        } else{
            System.out.println("Out of range");
        }
    }

    public void printCircles() {
        for (Circle ci : c) {
            System.out.println(ci.getRadius() + "\n"
                    + ci.getCircumference() + "\n"
                    + ci.getArea());
        }
    }

    public Circle getBiggestCircle() {
        Circle biggest = c[0];
        for (int i = 0; i < c.length; i++) {
            if (c[i] != null) {
                if (biggest.getArea() < c[i].getArea()) {
                    biggest = c[i];
                } else {
                }
            }
        }
        return biggest;
    }

    public Circle getSmallestCircle() {
        Circle smallest = c[0];
        for (int i = 0; i < c.length; i++) {
            if (c[i] != null) {
                if (smallest.getArea() > c[i].getArea()) {
                    smallest = c[i];
                } else {
                }
            }
        }
        return smallest;
    }

    public double getAverageCircle() {
        double total = 0;
        int num = 0;
        for (Circle c1 : c) {
            if (c1 != null) {
                total = total + c1.getArea();
                num++;
            }
        }
        return total / num;
    }

    public int getNumberOfUniquesCircles() {
        int num = 0;
        for (Circle c : c) {
            if (c != null) {
                num++;
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                if (c[i].getRadius() == c[j].getRadius() && j != i) {
                    System.out.println("the same in " + (i+1) + " and " + (j+1));
                    num--;
                    break;
                }
            }
        }
        return num;
    }

    public Circle[] getSameSizeCircles() {
        Circle[] array = new Circle[c.length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[i].getRadius() == c[j].getRadius() && j != i) {
                    array[i] = c[i];
                    break;
                }
            }
        }
        return array;
    }
    
    public int getNumMostCommonCircle(){
        int n = 0;
        int[] num = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[i].getRadius() == c[j].getRadius() && i!=j) {
                    num[i]++;
                }
            }
        }
        for (int i = 0; i < num.length; i++) {
            if(num[i]>n){
                n = num[i];
            }
        }
        return n+1;
    }
}
