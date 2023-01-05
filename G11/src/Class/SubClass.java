/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author 44869
 */

//What is the output of executing the following:
public class SubClass extends SuperClass {

    public void printMethod() {
        System.out.println("Printed in Subclass");
        super.printMethod();
    }

    public void printMethod2() {
        printMethod();
    }

    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.printMethod();
        s.printMethod2();
    }
}
