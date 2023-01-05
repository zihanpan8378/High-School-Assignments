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
public class ExcatlyElectrical {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        int d=input.nextInt();
        int x=input.nextInt();
        int n=Math.abs(a-c)+Math.abs(b-d);
        if (n>x) {
            System.out.println("N");
        }else{
            if ((x-n)%2==0) {
                System.out.println("Y");
            }else {
                System.out.println("N");
            }
        }
    }
}
