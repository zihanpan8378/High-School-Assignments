/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeatingChart;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Seat s = new Seat();

        s.add(new Student("Jean", "F", 90));
        s.add(new Student("Jay", "M", 78));
        s.add(new Student("Marie", "F", 89));
        s.add(new Student("Sean", "M", 77));
        s.add(new Student("Johnny", "M", 88));
        s.add(new Student("Hana", "F", 86));
        s.add(new Student("Finn", "M", 88));
        s.add(new Student("Ray", "M", 67));
        s.add(new Student("Lean", "F", 88));
        s.add(new Student("Lorna", "F", 76));
        s.add(new Student("Joy", "F", 78));
        s.add(new Student("Jim", "M", 85));
        do {
            System.out.print("-> Seating assignment by"
                    + "\nA - Alpha order\n"
                    + "B - Alternating (M F M F order)\n"
                    + "C - GPA Random"
                    + "\n>>");
            String choice = in.next().toLowerCase();
            if (choice.equals("a")) {
                s.sortAlpha();
                break;
            } else if (choice.equals("b")) {
                s.Alternating();
                break;
            } else if (choice.equals("c")) {
                s.random();
                break;
            } else {
                System.out.println("Wrong choice!!");
            }
        } while (0 == 0);
        s.print();
    }
}
