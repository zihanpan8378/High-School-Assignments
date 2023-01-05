/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class arrayPractice2 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int[] index;
        
        index = new int[10];
        
        System.out.println("Enter the Index: ");
        for(int i = 0;i<10;i++){
            int ind = in.nextInt();
            index[i] = ind;
        }
        
        System.out.println("Index	Square");
        for(int i = 0;i<10;i++){
            System.out.println(index[i]+"       "+ index[i]*index[i]);
        }
        
    }
}
