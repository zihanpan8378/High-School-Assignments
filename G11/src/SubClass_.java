/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44869
 */
public class SubClass_ extends Superclass_ {

    public static void printMethod1() {
        System.out.println("sub1");
    }

    public void printMethod2() {
        System.out.println("sub2");
    }

    public static void main(String[] args) {
        Superclass_ supe = new SubClass_();
        SubClass_ sub = new SubClass_();
        supe.printMethod1();// = Superclass_.printMethod1();
        sub.printMethod1();// = SubClass_.printMethod1();
        supe.printMethod2();
        sub.printMethod2();
    }
}
