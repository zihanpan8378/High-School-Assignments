/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencies;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author 44869
 */
public class Person implements Birthday{
    public String fName, lName;
    private int y, m, d;
    
    public Person(String fName, String lName){
        this.fName = fName;
        this.lName = lName;
    }
    
    @Override
    public void setBirthday(int y, int m, int d){
        this.y = y;
        this.m = m;
        this.d = d;
    }
    
    @Override
    public int getAge(){
        int age = 0;
        LocalDate birthday = LocalDate.of(y, Month.of(m), d);
        LocalDate now = LocalDate.now();
        
        Period period = Period.between(birthday, now);
        age = period.getYears();
        return age;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Person1{" + "fName=" + fName + ", lName=" + lName + '}';
    }
    
    
    
}

class testPerson{
    public static void main(String[] args) {
        Person p = new Person("John", "Smith");
        p.setBirthday(2000, 5, 19);
        System.out.println("Age: " + p.getAge());
    }
}
