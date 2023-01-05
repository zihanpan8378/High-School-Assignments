/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2019PracticeJ2;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class SumGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sw = new int[n];
        int[] se = new int[n];
        for (int i = 0; i < n; i++) {
            sw[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            se[i] = in.nextInt();
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j <= i; j++) {
                sum1 += sw[j];
                sum2 += se[j];
            }
            if(sum1==sum2&&sum1!=0){
                result = i+1;
            }
        }
        System.out.println(result);
    }
}
