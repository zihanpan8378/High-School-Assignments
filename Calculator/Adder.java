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
public class Adder implements Calculator{

    private double a, b;
    
    public Adder(double a, double b){
        this.a = a;
        this.b = b;
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
        return a + b; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Adder: " + getResult();
    }
    
}
