/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaQuiz;

/**
 *
 * @author 44869
 */
public class Choices {

    String a, b, c;

    public Choices(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "a - " + a + "\tb - " + b + "\tc - " + c;
    }

}
