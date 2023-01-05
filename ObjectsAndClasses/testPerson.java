/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectsAndClasses;

/**
 *
 * @author 44869
 */
public class testPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Jules", 16);
        
        System.out.println("Person 1 " + p1);
        System.out.println("Person 2 " + p2);
        /*p1.toString();
        p2.setName("Brandon");
        p1.setName("");*/
    }
}
