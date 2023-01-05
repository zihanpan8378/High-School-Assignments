/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReverseList;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class ReverseList {

    int[] list;
    int count;

    ReverseList() {
        list = new int[10];
        count = 0;
    }

    public void enter(int num) {
        if (count <= 10 && num != 999) {
            list[9 - count] = num;
            count++;
        } else if (count > 10) {
            System.out.println("Out of range!");
        }
    }

    public void print() {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != 0) {
                System.out.print(list[i] + " ");
            }
        }
    }

}

class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ReverseList r = new ReverseList();
        int num = 0;
        do {
            System.out.print("Enter a number (999 to quit): ");
            num = in.nextInt();
            r.enter(num);
        } while (num != 999);

        System.out.print("The list reversed is: ");
        r.print();
    }
}
