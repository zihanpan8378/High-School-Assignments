/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2016J1;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class J1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] games = new String[6];
        int count = 0;
        
        for (int i = 0; i < games.length; i++) {
            games[i] = in.nextLine();
            if (games[i].equals("W")) {
                count++;
            }
        }
        
        if (count >= 5) {
            System.out.println("1");
        } else if (count >= 3) {
            System.out.println("2");
        } else if (count >= 1) {
            System.out.println("1");
        } else {
            System.out.println("-1");
        }
    }
}
