/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2020PracticeS3;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        int[] num = new int[1001];
        
        for (int i = 0; i < num.length; i++) {
            num[i] = 0;
        }
        
        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
            num[list[i]]++;
        }
        
        int s1 = 0, s2 = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if(num[i]>s1){
                s1 = num[i];
                a[count] = i;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if(num[i]>s1){
                for (int j = 0; j < 10; j++) {
                    
                }
                s2 = num[i];
                
            }
        }
        
    }
    
    
}
