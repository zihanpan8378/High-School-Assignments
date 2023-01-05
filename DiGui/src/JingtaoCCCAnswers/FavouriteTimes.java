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
public class FavouriteTimes {
    public static int h;
    public static int m;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        h=12;
        m=0;
        int t=input.nextInt();
        while (t>=60) {
            t-=60;
            addh();
            for (int i=-4;i<=4;i++) {
                
            }
        }
    }
    
    public static void addh() {
        h+=1;
        if (h>12) {
            h-=12;
        }
    }
}
