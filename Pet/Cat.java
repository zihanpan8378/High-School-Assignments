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
public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String speak() {
        String catSpeak = "meow";
        return catSpeak;
    }
}
