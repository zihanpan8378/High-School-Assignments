/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListDemo;

/**
 *
 * @author maanderson
 */
public class Student {

    String ID, name;
    double GPA;

    public Student(String ID, String name, double GPA) {
        this.name = name;
        this.ID = ID;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "ID: " + ID + " name: " + name + "\tGPA: " + GPA;
    }

}
