/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC;

/**
 *
 * @author 44869
 */
public class RMTMethods {

    public int[] operat(int[] before) {
        int[] after = new int[before.length];
        after[0] = before[before.length - 1];
        for (int i = 1; i < after.length; i++) {
            after[i] = before[i - 1];
        }
        return after;
    }

    public int check(int[] stations, int a, int b) {
        int passangers = 0;
        for (int i = a - 1; i < b; i++) {
            passangers += stations[i];

        }
        return passangers;
    }
}
