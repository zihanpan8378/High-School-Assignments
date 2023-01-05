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
public class Taxman_Player {

    String name, taxman;
    int user, tax;
    Scanner in = new Scanner(System.in);
    

    public void User() {
        System.out.println("Welcome - can you make more than the taxman? ");
        System.out.print("What is your name? ");
        name = in.nextLine();
        
    }

    public void Taxman() {

    }
}
