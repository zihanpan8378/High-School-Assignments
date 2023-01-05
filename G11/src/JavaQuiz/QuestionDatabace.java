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
public class QuestionDatabace {

    Question[] q;
    Choices[] c;

    public QuestionDatabace(Question[] q, Choices[] c) {
        this.q = q;
        this.c = c;
    }

    public QuestionDatabace() {
        this.q = new Question[5];
        this.c = new Choices[5];
    }

    public Question[] getQ() {
        return q;
    }

    public void setQ(Question[] q) {
        this.q = q;
    }

    public Choices[] getC() {
        return c;
    }

    public void setC(Choices[] c) {
        this.c = c;
    }

    public void printDatabace() {
        for (int i = 0; i < q.length; i++) {
            if (getQ()[i] != null && getC()[i] != null) {
                System.out.println((i+1) + getQ()[i].toString() + getC()[i].toString());
            }
        }
    }
}
