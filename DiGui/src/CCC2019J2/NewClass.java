/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2019J2;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class NewClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String result = "";

        for (int i = 0; i < num; i++) {
            int a = in.nextInt();
            String b = in.next();
            for (int j = 0; j < a; j++) {
                result+=b;
            }
            result=result+"\n";
        }

        System.out.println(result);
    }
}
