/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circle;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testCircles {

    public static void main(String[] args) {
        NumberFormat nf = new DecimalFormat("0.00");
        Scanner in = new Scanner(System.in);
        Circles o = new Circles();
        System.out.println("How many circles to add?");
        o.length = in.nextInt();
        //int many = in.nextInt();
        o.c = new Circle[o.length];
        //double[] radius = new double[many];
        double radiu;

        for (int i = 0; i < o.length; i++) {
            System.out.println("Circle " + (i + 1) + " radius: ");
            //radius[i] = in.nextInt();
            radiu = in.nextInt();
            o.addCircle(new Circle(radiu));
        }

        System.out.println("printing all circles");
        for (int i = 0; i < o.length; i++) {
            System.out.println("");
            System.out.println(i + 1);
            System.out.println(o.c[i]);
            /*System.out.println("Radius: " + nf.format(o.c[i].getRadius()));
            System.out.println("Circle Area: " + nf.format(o.c[i].getArea()));
            System.out.println("Circle circumference: " + nf.format(o.c[i].getCircumference()));*/
        }

        System.out.println("\n\nbiggest circle");
        System.out.println(o.getBiggestCircle());
        /*System.out.println("Radius: " + nf.format(o.getBiggestCircle().getRadius()));
        System.out.println("Circle Area: " + nf.format(o.getBiggestCircle().getArea()));
        System.out.println("Circle circumference: " + nf.format(o.getBiggestCircle().getCircumference()));*/

        System.out.println("\n\nsmallest circle");
        System.out.println(o.getSmallestCircle());
        /*System.out.println("Radius: " + nf.format(o.getSmallestCircle().getRadius()));
        System.out.println("Circle Area: " + nf.format(o.getSmallestCircle().getArea()));
        System.out.println("Circle circumference: " + nf.format(o.getSmallestCircle().getCircumference()));*/

        System.out.println("\n\naverage circle size");
        System.out.println(nf.format(o.getAverageCircle()));

        System.out.println("\n\nnumber of unique circles");
        System.out.println(o.getNumberOfUniquesCircles());

        System.out.println("\n\nCircle with the same size");
        for (int i = 0; i < o.getSameSizeCircles().length; i++) {
            if (o.getSameSizeCircles()[i] != null) {
                System.out.println(i+1);
                System.out.println(o.getSameSizeCircles()[i]+"\n");
                /*System.out.println("Radius: " + nf.format(o.getSameSizeCircles()[i].getRadius()));
                System.out.println("Circle Area: " +nf.format( o.getSameSizeCircles()[i].getArea()));
                System.out.println("Circle circumference: " + nf.format(o.getSameSizeCircles()[i].getCircumference()) + "\n");*/
            }
        }
        
        System.out.println(o.getNumMostCommonCircle());
    }
}
