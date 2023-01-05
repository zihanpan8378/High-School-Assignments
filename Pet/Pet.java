/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet;

/**
 *
 * @author 44869
 */
public abstract class Pet {

    private String myName;

    public Pet(String name) {
        myName = name;
    }

    public String getName() {
        return myName;
    }

    public abstract String speak();
}
