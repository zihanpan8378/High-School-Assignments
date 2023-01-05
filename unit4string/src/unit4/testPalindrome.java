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
public class testPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Palindrome p = new Palindrome();
        
        System.out.println("Enter your word: ");
        String w = in.nextLine();
        p.setword(w);
        
        //String W = p.getword();
        
        /*int i;
        for (i = 1; i <= W.length(); i++) {
            System.out.println(W.substring(i-1, i));  
            System.out.println(W.substring(W.length() - (i), W.length() - (i-1)));
        }*/
        
        if (p.getanswer() == true){
            System.out.println("It is a Palindrome.");
        }
        else {
            System.out.println("It isn't a Palindrome.");
        }
        
        
    }
}
