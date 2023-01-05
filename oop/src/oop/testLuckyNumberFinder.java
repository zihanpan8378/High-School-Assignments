/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testLuckyNumberFinder {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        LuckyNumberFinder lnf = new LuckyNumberFinder();
        int i;
        System.out.print("Do you want to enter your number by your self (enter 1) "
                + "or to generate rendom numbers by computer (enter 2):\t");
        int choice = in.nextInt();
        System.out.print("please enter how many times that you want to check:\t");
        int times=in.nextInt();
        for(i=0;i<times;i++){
        if(choice==1){
                System.out.print("please enter the number:\t");
                lnf.setNum(in.nextInt());                
        }
        if(choice==2){
                lnf.setNumRandom();                          
        }
        lnf.setIsLucky();
        lnf.setIsOdd();
        System.out.println(lnf.showNumStatus());
        }       
    }    
}
