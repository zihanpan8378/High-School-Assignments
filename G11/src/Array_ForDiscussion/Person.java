/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array_ForDiscussion;

import Person.*;

/**
 *
 * @author 44869
 */
public class Person {
    private String name;
    private int age;

    public Person(String n, int a){
        name = n;
        age = a;  
    }
    
    public Person(){
        name = "";
        age = 0;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString(){
        return "Name: " + name + "\n" + "Age: " + age; 
    }
    
    
}
