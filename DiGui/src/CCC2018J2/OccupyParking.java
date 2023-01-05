/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2018J2;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class OccupyParking {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] occupy1 = new String[n], occupy2 = new String[n];
        for (int i = 0; i < occupy1.length; i++) {
            occupy1[i] = in.next().toUpperCase();
        }
        for (int i = 0; i < occupy2.length; i++) {
            occupy2[i] = in.next().toUpperCase();
        }
        int count =0;
        for (int i = 0; i < occupy1.length; i++) {
            if(occupy2[i].equals(occupy1[i])&&occupy2[i].equals("C")){
                count++;
            } 
        }
        System.out.println(count);
    }
}
