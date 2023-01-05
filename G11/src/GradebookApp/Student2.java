/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GradebookApp;

import java.util.Arrays;

/**
 *
 * @author maanderson
 */
/*public class Student2 implements Comparable<Student> {

    String name;
    double grade;

    public Student2(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", grade=" + grade + '}';
    }

   // @Override
    /*public int compareTo(Student o) {
        //sorts in ascending order
        //Double g = grade;
        //return g.compareTo(o.getGrade());
        
        if (this.grade < o.getGrade()) {
            return -1;
        } else if (o.getGrade() < this.grade) {
            return 1;
        }
        return 0;
    }*/

//}

class StudentArray2 {

    Student[] list;
    int count;
    
    public StudentArray2() {
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

class testArray2 {

    public static void main(String[] args) {
        StudentArray sa = new StudentArray();
        sa.add(new Student("John", 78));
        sa.add(new Student("Al", 89));
        sa.add(new Student("Sam", 67));
        sa.add(new Student("Peter", 81));
        sa.add(new Student("Matt", 90));

        Arrays.sort(sa.list);
        sa.printStudents();

    }
}
