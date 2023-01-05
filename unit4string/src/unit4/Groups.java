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
public class Groups {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        String w = in.nextLine();

        String Group1 = "";
        String Group2 = "";
        String s = " " + w + " ";
        int space, space2;
        String a, b;
        
        space = s.indexOf(" ");
        while (space != -1) {
            space2 = s.indexOf(" ", space + 1);
            a = s.substring(space + 1, space2);
            space = space2;
            Group1 = a + Group1 + "/n";
            /*space2 = s.indexOf(" ", space+1);
            b = s.substring(space, space2);
            space = space2;
            Group2 = b + Group1+"/n";*/
        }
        System.out.println("Group1" + Group1 + "/n" + "Group2" + Group2);
    }
}
