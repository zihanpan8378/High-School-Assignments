/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2019PracticeJ1;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Main {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int result = 0;
        result = num/2+1;
        if(num>5){
            result-=num-5;
        }
        if(num ==10){
            result = 1;
        }
        System.out.println(result);
    }
}
