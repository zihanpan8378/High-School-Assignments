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
public class testFormative2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Formative2 f = new Formative2();
        
        System.out.println("Enter your sentence: ");
        String s = in.nextLine();
        f.setOrigin(s);
        
        System.out.println(f.getAnswer());
        
    }    
}
