/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GradebookApp;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testGradebookApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Gradebook g = new Gradebook();
        int choice;

        System.out.println("Main Menu\n"
                + "1 - Add student to roster\n"
                + "2 - Print all students info\n"
                + "3 - Get student info\n"
                + "4 - Remove student from gradebook\n"
                + "5 - Get student info with highest Grade Average\n"
                + "6 - Get student info with lowest Grade Average\n"
                + "7 - Get failing students (average < 50)\n"
                + "8 - Get top 3 students (Sorted from highest to lowest)\n"
                + "0 - Quit\n\n");
        
        do {
            System.out.println("Enter your choice: ");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Enter first name: ");
                String fn = in.next();
                System.out.println("Enter last name: ");
                String ln = in.next();
                System.out.println("Enter Math grade: ");
                double mg = in.nextDouble();
                System.out.println("Enter Literature grade: ");
                double lg = in.nextDouble();
                System.out.println("Enter Science grade: ");
                double sg = in.nextDouble();
                System.out.println("Enter History grade: ");
                double hg = in.nextDouble();
                g.add(new Student(fn, ln, mg, lg, sg, hg));
            } else if (choice == 2) {
                g.print(g.s);
            } else if (choice == 3) {
                System.out.println("Enter first name: ");
                String fn = in.next();
                System.out.println("Enter last name: ");
                String ln = in.next();
                g.printOne(new Student(fn, ln, 0, 0, 0, 0));
            } else if (choice == 4) {
                System.out.println("Enter student's first name to remove: ");
                String fn = in.next();
                System.out.println("Enter student's last name to remove: ");
                String ln = in.next();
                g.remove(fn, ln, g.s);
                System.out.println(fn + "has been removed from the gradebook");
            } else if (choice == 5) {
                System.out.println("Student with highest GPA: ");
                g.printHighest();
            } else if (choice == 6) {
                System.out.println("Student with lowest GPA: ");
                g.printLowest();
            } else if (choice == 7) {
                System.out.println("Failed students");
                int count = 0;
                for (int i = 0; i < g.fail().length; i++) {
                    if (g.fail()[i] != null) {
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("There are no failing students");
                } else {
                    g.print(g.fail());
                }
            } else if (choice == 8) {
                System.out.println("Top 3");
                g.print(g.top3());
            } else if (choice == 0) {
                System.out.println("Thank you...");
                break;
            }
        } while (choice != 0);

    }
}
