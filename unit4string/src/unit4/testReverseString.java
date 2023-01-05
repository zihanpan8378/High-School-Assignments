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
public class testReverseString {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ReverseString backward = new ReverseString();

        System.out.print("Enter the word or phrase: ");
        String s = in.nextLine();
        backward.setString(s);

        System.out.println("Your original word or phrase: " + backward.getString());
        System.out.println("The word or phrase in reverse: " + backward.getReverse());

    }

}
