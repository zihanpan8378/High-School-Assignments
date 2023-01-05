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
public class AssignmentGrades {

    String[] names;
    double[] scores;
    int numStudents;

    Scanner in = new Scanner(System.in);

    public String[] getNames() {
        return names;
    }

    public void setNamesandScores() {
        names = new String[numStudents];
        scores = new double[numStudents];

    }

    public void setNumStudents() {
        System.out.print("Enter the number of students: ");
        numStudents = in.nextInt();
    }

    public void setInfo() {
        setNamesandScores();

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter a name: ");
            String name = in.next();
            names[i] = name;
            System.out.println("Enter the grade: ");
            scores[i] = in.nextDouble();
        }
        for (int i = 0; i < numStudents; i++) {
            System.out.println(getNames()[i] + scores[i]);
        }

    }

    public void setHighest() {
        double h = scores[0];
        String n = names[0];
        for (int i = 1; i < numStudents; i++) {
            if (h < scores[i]) {
                h = scores[i];
                n = names[i];
            }
        }
        System.out.print("The highest one is: " + n + h);
    }

}
