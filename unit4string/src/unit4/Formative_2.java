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
public class Formative_2 {

    int[] num = new int[25];
    int i = -1;
    Scanner in = new Scanner(System.in);

    public void setNum() {
        String o_f = "", s_t = "", e_ft = "", st_tw = "";
        do {
            i++;
            System.out.println("Enter a number from 1 to 20 (-1 to end):");
            num[i] = in.nextInt();
            if (num[i] != -1) {
                if (num[i] < 6) {
                    o_f += "*";
                } else if (num[i] < 11) {
                    s_t += "*";
                } else if (num[i] < 16) {
                    e_ft += "*";
                } else if (num[i] < 21) {
                    st_tw += "*";
                }
            }
            //System.out.println(num[i]);
        } while (num[i] != -1);
        num[i] = 0;
        System.out.println("1 to 5: " + o_f + "\n" 
                            + "6 to 10: " + s_t + "\n" 
                            + "11 to 15: " + e_ft + "\n" 
                            + "16 to 20: " + st_tw);
    }

    public void getAverage() {
        double average = 0;
        for (int q = 0; q <= i; q++) {
            average += num[q];
        }
        average = average / (i);
        System.out.println("The average of the numbers entered is: " + average);
    }

    public int getMaximum() {
        int maximum = 0;
        for (int q = 0; q <= i; q++) {
            if (num[q] > maximum && num[q] != 0) {
                maximum = num[q];
            }
        }
        return maximum;
    }

    public int getMinimum() {
        int minimum = 100000000;
        for (int q = 0; q <= i; q++) {
            if (num[q] < minimum && num[q] != 0) {
                minimum = num[q];
            }
        }
        return minimum;
    }

    public void getRange() {
        int range = getMaximum() - getMinimum();
        System.out.println("The average of the numbers entered is: " + range);
    }
}
