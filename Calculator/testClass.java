/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author 44869
 */
public class testClass {

    public static void main(String[] args) {
        Adder a = new Adder(3.0, 3.0);
        Multiplier m = new Multiplier(2.0, 2.0);
        Power p = new Power(a, m);

        System.out.println(a);
        System.out.println(m);
        System.out.println(p.getA() + " to the power of " + p.getB() + " = " + p.getResult());
    }
}
