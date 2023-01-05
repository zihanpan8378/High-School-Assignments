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
public class Groupassigner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Name3 n = new Name3();

        System.out.println("Enter your last name.");
        String l = in.nextLine();
        n.setLastname(l);

        System.out.println("Your group assignment: " + n.getGroup());
    }
}


