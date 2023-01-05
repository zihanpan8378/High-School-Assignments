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
public class testSummative2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Summative2 p = new Summative2();
        
        System.out.println("Enter a string with no punctuation: ");
        String s = in.nextLine();
        p.setPhrase(s);
        
        System.out.println("Enter number of words to move: ");
        int n = in.nextInt();
        p.setWords(n);
        
        System.out.println(p.getAnswer());
    }    
}
