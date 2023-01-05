/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2017J4;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class FavouriteTimes {

    int hour, minute;

    public int check(int minutes) {
        int num = 0;
        hour = minutes / 60;
        minute = minutes % 60;
        int count = 0;
        while(hour>=12){
            hour-=12;
            count++;
        }
        num = count*31;
        if (hour != 0) {
            for (int i = 0; i <= hour - 1; i++) {
                for (int j = 0; j <= 59; j++) {

                    int t1, t2, t3, t4;
                    if (i == 0) {
                        t1 = 1;
                        t2 = 2;
                    } else {
                        t1 = i / 10;
                        t2 = i % 10;
                    }
                    t3 = j / 10;
                    t4 = j % 10;
                    if (t1 == 0) {
                        if (t4 - t3 == t3 - t2) {
                            num++;
                        }
                    } else {
                        if (t4 - t3 == t3 - t2 && t3 - t2 == t2 - t1) {
                            num++;
                        }
                    }
                    System.out.println(t1 + " " + t2 + " " + t3 + " " + t4);
                }
            }

            for (int i = 0; i <= 0; i++) {
                for (int j = 0; j <= minute; j++) {

                    int t1, t2, t3, t4;

                    t1 = hour / 10;
                    t2 = hour % 10;
                    t3 = j / 10;
                    t4 = j % 10;
                    if (t1 == 0) {
                        if (t4 - t3 == t3 - t2) {
                            num++;
                        }
                    } else {
                        if (t4 - t3 == t3 - t2 && t3 - t2 == t2 - t1) {
                            num++;
                        }
                    }
                    //System.out.println(t1 + " " + t2 + " " + t3 + " " + t4);
                }
            }
        } else {
            for (int i = 0; i <= hour; i++) {
                for (int j = 0; j <= minute; j++) {
                    int t1, t2, t3, t4;
                    if (i == 0) {
                        t1 = 1;
                        t2 = 2;
                    } else {
                        t1 = i / 10;
                        t2 = i % 10;
                    }
                    t3 = j / 10;
                    t4 = j % 10;
                    if (t1 == 0) {
                        if (t4 - t3 == t3 - t2) {
                            num++;
                        }
                    } else {
                        if (t4 - t3 == t3 - t2 && t3 - t2 == t2 - t1) {
                            num++;
                        }
                    }
                    System.out.println(t1 + " " + t2 + " " + t3 + " " + t4);
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FavouriteTimes ft = new FavouriteTimes();

        int minutes = in.nextInt();
        System.out.println(ft.check(minutes));
        //System.out.println(ft.hour + " " + ft.minute);
        /*for (int i = 0; i < 4; i++) {
            System.out.print(ft.display(minutes)[i]);
        }*/
    }
}
