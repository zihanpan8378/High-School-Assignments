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
public class MonogramMaker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Name4 n = new Name4();
        int i;
        String answer = "";

        System.out.println("How many names to process?");
        int t = in.nextInt();
        n.setNum(t);

        String unuseful = in.nextLine();
        n.setFullname(unuseful);

        for (i = 0; i < n.getNum(); i++) {
            System.out.println("Enter full name " + (i + 1));
            String f = in.nextLine();
            n.setFullname(f);
            n.setFirstname();
            n.setMiddlename();
            n.setLastname();
            answer += (i + 1 + ": " + n.getMonogram() + "  " + "\n");
        }
        System.out.println(answer);
    }
}
