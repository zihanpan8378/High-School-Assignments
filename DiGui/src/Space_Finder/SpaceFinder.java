/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Space_Finder;

import java.util.Scanner;

/**
 *
 * @author 44485
 */
public class SpaceFinder {

    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter the phrase and the current location: ");
        System.out.println(spaceDistance(in.nextLine(), in.nextInt()));
        System.out.println();
    }

    public static int spaceDistance(String a, int i) {
        if (a.charAt(i) == ' ') {
            return 1;
        } else {
            return spaceDistance(a.substring(i + 1), 0) + 1;
        }
    }
}
