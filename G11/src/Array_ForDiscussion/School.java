/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array_ForDiscussion;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class School {

    private String sName;
    private Student[] students;
    int count;

    public School(String sn) {
        sName = sn;
        count = 0;
        students = new Student[5];

    }

    public void add(Student s) {
        if (count < students.length) {
            students[count] = s;
            count++;
        }

    }

    /*public void fillStudents() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < students.length; i++) {
            //String n2 = input.nextLine();
            System.out.print("Enter name: ");
            String n = input.next();
            System.out.print("Enter age: ");
            int a = input.nextInt();
            System.out.print("Enter GPA: ");
            double gpa = input.nextDouble();
            students[i] = new Student(n, a, gpa);

        }
    }*/
    public void printArray() {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}

class testSchool {

    public static void main(String[] args) {
        School school = new School("JIS");

        //school.fillStudents();
        school.printArray();

        Student s1 = new Student("P", 16, 99);
        school.add(s1);
        school.printArray();
    }
}
