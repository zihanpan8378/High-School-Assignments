/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hanoi;

/**
 *
 * @author 44869
 */
public class Question7 {

    /*public static double simpsonRule(double a, double b){
        if(b-a<=1){
            return (a*a+b*b)/2;
        }
        double m = (a+b)/2;
        System.out.println(m);
        System.out.println(a+" "+m+" "+b);
        return simpsonRule(a,m) + simpsonRule(m,b);
        
    }
    
    public static void main(String[] args) {
        System.out.println(simpsonRule(0,4));
    }*/

    public static double sum(double[] v, int n) {
        if (n == 0) {
            return 0;
        }
        return sum(v, n - 1) + v[n - 1];

    }

    public static double mystery(double[] v, int n) {
        if (n == 0) {
            return 0;
        } else {
            return mystery(v, n - 1) + sum(v, n - 1) * v[n - 1];
        }
    }

    public static void main(String[] args) {
        double[] v = {-2, -1, 0, 1, 2};
        System.out.println(mystery(v, v.length));
    }
}
