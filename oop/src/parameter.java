/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44869
 */
public class parameter {

    public static void swap(int A, int B) {
        int temp = A;
        A = B;
        B = temp;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        swap(a, b);
        System.out.println(a + " " + b);
    }
}
