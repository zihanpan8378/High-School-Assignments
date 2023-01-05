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
public class HasNext {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "";
        while (input.hasNext()) {
            int n = input.nextInt();
            s += n + " ";
            System.out.println(s);
        }
    }
}
