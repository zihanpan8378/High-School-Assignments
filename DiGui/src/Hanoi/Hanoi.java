/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hanoi;

import java.util.Scanner;

/**
 *
 * @author 44485
 */
public class Hanoi {
    static int s=0;
    public static void main(String[] args) {
         int n = 0;  
        Scanner console = new Scanner(System.in);  
        n = console.nextInt();  
        System.out.println("汉诺塔层数为" + n);  
        System.out.println("移动方案为：");  
        hanoi(n, 'a', 'b', 'c');  
        System.out.println("需要移动次数：" + s); 
    }
    
    static void hanoi(int n,char a,char b,char c){
        if(n==1){
            System.out.println("n="+n+" "+a+"-->"+c);
            s++;
        }
        else{
            hanoi(n-1,a,c,b);
            System.out.println("n="+n+" "+a+"-->"+c);
            hanoi(n-1,b,c,a);
            s++;
        }
    }
}
