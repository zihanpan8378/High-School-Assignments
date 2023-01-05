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
public class Question {
    String q, a;

    public Question(String q, String a) {
        this.q = q;
        this.a = a;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return getQ() + "\n";
    }
    
    
}
