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
public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String speak() {
        String dogsound = "woof";
        return dogsound;
    }

}

class testDog {

    public static void main(String[] args) {
        Dog d = new Dog("dog");
        System.out.println(d.speak());
    }
}
