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
public class Student implements Comparable<Student> {

    String firstName, lastName;
    double mathGrade, literatureGrade, scienceGrade, historyGrade;
    double grade;

    Student(String f, String ln, double m, double lg, double s, double h) {
        firstName = f;
        lastName = ln;
        mathGrade = m;
        literatureGrade = lg;
        scienceGrade = s;
        historyGrade = h;
    }
    
    Student(String f, double g) {
        firstName = f;
        grade = g;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public double getLiteratureGrade() {
        return literatureGrade;
    }

    public void setLiteratureGrade(double literatureGrade) {
        this.literatureGrade = literatureGrade;
    }

    public double getScienceGrade() {
        return scienceGrade;
    }

    public void setScienceGrade(double scienceGrade) {
        this.scienceGrade = scienceGrade;
    }

    public double getHistoryGrade() {
        return historyGrade;
    }

    public void setHistoryGrade(double historyGrade) {
        this.historyGrade = historyGrade;
    }

    public double getAverage() {
        double total;
        total = getMathGrade() + getLiteratureGrade() + getScienceGrade() + getHistoryGrade();
        return total / 4;
    }

    public String getLetterGrade() {
        String letter;
        if (getAverage() >= 85) {
            letter = "A*";
        } else if (getAverage() >= 80) {
            letter = "A";
        } else if (getAverage() >= 70) {
            letter = "B";
        } else if (getAverage() >= 60) {
            letter = "C";
        } else if (getAverage() >= 50) {
            letter = "D";
        } else {
            letter = "F";
        }
        return letter;
    }

    @Override
    public String toString() {
        return getFirstName() + "\t" + getLastName() + "\t"
                + getMathGrade() + "\t" + getLiteratureGrade() + "\t"
                + getScienceGrade() + "\t" + getHistoryGrade() + "\t"
                + getAverage() + "\t" + getLetterGrade();
    }

    @Override
    public int compareTo(Student o) {
        if (this.grade<o.getAverage()){
            return -1;
        } else if (o.getAverage() < this.grade){
            return 1;
        }
        return 0;
    }

}

class StudentArray {

    Student[] list;
    int count;

    public StudentArray() {
        list = new Student[5];
        count = 0;
    }

    public void add(Student s) {
        if (count < list.length) {
            list[count] = s;
        }
        count++;
    }

    public void printStudents() {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}

class testArray {

    public static void main(String[] args) {
        StudentArray sa = new StudentArray();
        sa.add(new Student("John", 78));
        sa.add(new Student("Al", 89));
        sa.add(new Student("Sam", 67));
        sa.add(new Student("Peter", 81));
        sa.add(new Student("Matt", 90));

        Arrays.sort(sa.list);
        
        sa.printStudents();
        
        /*sa.printStudents();
        double[] grades = new double[sa.list.length];
        int[] ind = new int[sa.list.length];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = sa.list[i].getAverage();
            ind[i] = i;
        }
        double[] grades2 = grades;
        
        Arrays.sort(grades);
        for (int i = 0; i < ind.length; i++) {
            Student s = new Student(sa.list[ind[i]].getName(), sa.list[ind[i]].getGrade())
            System.out.print(s);
        }*/
    }
}
