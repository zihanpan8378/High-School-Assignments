/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankApp;

/**
 *
 * @author 44869
 */
public class Person {
    String fName, lName;
    int age = 0;
    

    public Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
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
        return fName + "\t" + lName;
    }
    
    
}
