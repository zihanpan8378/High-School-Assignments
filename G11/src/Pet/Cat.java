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
public class Cat extends Animal__ {

    
    public static void testClassMethod1() {
        System.out.println("The static method 1 in Cat");
        Cat.testClassMethod2();
    }

    public static void testClassMethod2() {
        Animal__.testClassMethod1();
        System.out.println("The static method 2 in Cat");
    }

    public void testInstanceMethod() {
        super.testInstanceMethod();
        System.out.println("The instance method in Cat");
    }


        public static void main(String[] args) {
            Cat myCat = new Cat();
            Animal__ myAnimal = myCat;
            Animal__.testClassMethod1();

            Cat.testClassMethod2();

            Cat.testClassMethod1();

            myAnimal.testInstanceMethod();
        }
    /*public Cat(String name) {
        super(name);
    }

    @Override
    public String speak() {
        String catSpeak = "meow";
        return catSpeak;
    }*/
}
