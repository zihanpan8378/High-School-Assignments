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
public class Sum_Game {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n,x,j,sum;
        n=input.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=input.nextInt();
        }
        j=0;
        x=0;
        for (int i=0;i<n;i++){
            x=x+input.nextInt()-a[i];
            if (x==0) {
                j=i+1;
            }
        }
        System.out.println(j);
        
    }
}
