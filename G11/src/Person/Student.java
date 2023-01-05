/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

/**
 *
 * @author 44869
 */
public class Student/*subclass*/ extends Person/*super class*/{
    private double gpa;
    
    public Student(String name, int age, double gpa){
        super(name, age);
        this.gpa = gpa;
    }
    
    public Student(){
        
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString();// + "\nStudent{" + "gpa=" + gpa + '}';
    }
    
}

class testStudent{
    public static void main(String[] args) {
        Student s1 = new Student("Yihang", 16, 99);
        System.out.println(s1);
    }
}
