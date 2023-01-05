/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practise;

import java.util.Scanner;

/**
 *
 * @author 40474
 */
public class ShiftySum {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int k=a;
        int sum=a;
        for (int i=0;i<b;i++) {
            k*=10;
            sum+=k;
        }
        System.out.println(sum);
       
    }
}
