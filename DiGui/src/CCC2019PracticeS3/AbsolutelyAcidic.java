/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2019PracticeS3;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class AbsolutelyAcidic {
    
    int[] river, frequency;
    Scanner in = new Scanner(System.in);

    AbsolutelyAcidic(int length) {
        river = new int[length];
        frequency = new int[1000];
    }

    public void enter() {
        for (int i = 0; i < river.length; i++) {
            river[i] = in.nextInt();
            frequency[river[i]]++;
        }
    }

    public int mostFrequency() {
        int most = 0, count = 0;
        int[] freq1 = new int[river.length];
        int[] freq2 = new int[river.length];
        int result = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > most) {
                most = frequency[i];
            }
        }
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == most) {
                freq1[count] = i;
                count++;
                frequency[i] = 0;
            }
        }
        if (count >= 2) {
            int min = freq1[0], max = 0;

            for (int i = 0; i < count; i++) {
                if (freq1[i] < min) {
                    min = freq1[i];
                }
                if (freq1[i] > max) {
                    max = freq1[i];
                }
            }
            result = max - min;
        } else {
            most = 0;
            count = 0;
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] > most) {
                    most = frequency[i];
                }
            }
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] == most) {
                    freq2[count] = i;
                    count++;
                }
            }

            int max2 = 0, min2 = freq2[0];
            for (int i = 0; i < count; i++) {
                if (freq2[i] < min2) {
                    min2 = freq2[i];
                }
                if (freq2[i] > max2) {
                    max2 = freq2[i];
                }
            }
            //System.out.println(max2 + " " + min2 + " " + freq1[0]);
            if (Math.abs(freq1[0] - min2) > Math.abs(freq1[0] - max2)) {
                result = Math.abs(freq1[0] - min2);
            } else {
                result = Math.abs(freq1[0] - max2);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        AbsolutelyAcidic m = new AbsolutelyAcidic(n);
        m.enter();
        System.out.println(m.mostFrequency());

    }
}
