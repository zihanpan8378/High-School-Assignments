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
public class Practice3 {
    int[] num, ind;
    int times;
    Scanner in = new Scanner(System.in);
    
    public void setIndNum(){
        
        System.out.println("Enter the times that you want to do: ");
        times = in.nextInt();
        num = new int[times];
        ind = new int[times];
        System.out.println("Index	Numbers");
        
        for(int i = 0; i<times;i++){
            ind[i] = i;
            num[i] = times - i -1;
            System.out.println(ind[i]+"       "+num[i]);
        }
        
        
    }
}
