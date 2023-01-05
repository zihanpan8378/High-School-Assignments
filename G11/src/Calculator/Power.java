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
public class Power implements Calculator {

    private double a, b;

    public Power(Adder a, Multiplier b) {
        this.a = a.getResult();
        this.b = b.getResult();
    }

    @Override
    public void setA(double a) {
        this.a = a; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setB(double b) {
        this.b = b; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getA() {
        return a; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getB() {
        return b; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getResult() {
        /*double result = a;
        for (int i = 0; i < b; i++) {
            result = result * b;
        }
        return result; //To change body of generated methods, choose Tools | Templates.*/
        return Math.pow(a, b);
    }

    @Override
    public String toString() {
        return "\nPower: " + getResult();
    }

}
