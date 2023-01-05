/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GradebookApp;

import java.util.Arrays;

/**
 *
 * @author 44869
 */
public class Gradebook {

    Student[] s;
    int count = 0;

    Gradebook() {
        s = new Student[10];
    }

    public void add(Student student) {
        if (count < s.length) {
            s[count] = student;
            count++;
        } else {

        }
    }

    public void remove(String fn, String ln, Student[] student) {
        int i;
        for (i = 0; i < student.length; i++) {
            if (student[i].getFirstName().equals(fn)
                    && student[i].getLastName().equals(ln)) {
                break;
            }
        }
        if (i == (student.length - 1)) {
            System.out.println("There isn't this student.");
        } else {
            for (int j = i; j < student.length - 1; j++) {
                student[j] = student[j + 1];
            }
            student[student.length - 1] = null;
            if (count != 0) {
                count--;
            }
        }
    }

    public void print(Student[] student) {
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null) {
                System.out.println(student[i]);
            }
        }
    }

    public void printOne(Student student) {
        int i;
        for (i = 0; i < s.length; i++) {
            if (s[i].getFirstName().equals(student.getFirstName())
                    && s[i].getLastName().equals(student.getLastName())) {
                break;
            }
        }
        if (i == (s.length - 1)) {
            System.out.println("There isn't this student.");
        } else {
            System.out.println(s[i]);
        }
    }

    public void printHighest() {

        double highest = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                if (s[i].getAverage() > highest) {
                    highest = s[i].getAverage();
                } else {

                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                if (s[i].getAverage() == highest) {
                    printOne(s[i]);
                }
            }
        }
    }

    public void printLowest() {
        double lowest = 100;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                if (s[i].getAverage() < lowest) {
                    lowest = s[i].getAverage();
                } else {

                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                if (s[i].getAverage() == lowest) {
                    printOne(s[i]);
                }
            }
        }
    }

    public Student[] fail() {
        int c = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                if (s[i].getAverage() < 50) {
                    c++;
                }
            }
        }
        Student[] f = new Student[c + 1];
        c = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                if (s[i].getAverage() < 50) {
                    f[c] = s[i];
                    c++;
                }
            }
        }
        return f;
    }

    public Student[] top3() {
        Student[] t3 = new Student[3];
        Student[] m = new Student[s.length];
        for (int i = 0; i < m.length; i++) {
            m[i] = s[i];
        }
        for (int i = 0; i < t3.length; i++) {
            double highest = 0;
            int count2 = 0;
            for (int j = 0; j < m.length; j++) {
                if (m[j] != null) {
                    if (m[j].getAverage() > highest) {
                        highest = m[j].getAverage();
                        count2 = j;
                    }
                }
            }
            t3[i] = m[count2];
            remove(m[count2].getFirstName(), m[count2].getLastName(), m);
        }
        /*Student[] m = new Student[s.length];
        for (int i = 0; i < m.length; i++) {
            m[i] = s[i];
        }
        double[] k = new double[s.length];
        for(int i = 0; i<s.length; i++){
            k[i] = s[i].getAverage();
        }
        Arrays.sort(k);
        
        Student[] t = {m[0], m[1], m[2]};*/
        return t3;

    }

    /*public void getTopStudents() {
        Student[] backup = new Student[students.length];
        Student t = new Student();
        for (int i = 0; i < backup.length; i++) {
            backup[i] = students[i];
        }

        for (int i = 0; i < backup.length; i++) {
            for (int j = 0; j < backup.length - i; j++) {
                if (backup[j] != null && backup[j + 1] != null) {
                    if (backup[j].getAverage() < backup[j + 1].getAverage()) {
                        t = backup[j];
                        backup[j] = backup[j + 1];
                        backup[j + 1] = t;
                    }
                }
            }

        }
        System.out.println("Name\tMath\tLit\tScience\tHistory\tAverage\tLetter Grade");
        for (int i = 0; i < 3; i++) {
            System.out.println(backup[i]);
        }
    }*/

}
