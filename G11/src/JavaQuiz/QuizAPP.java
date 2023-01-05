/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizApp;

/**
 *
 * @author 44869
 */
public class QuizAPP {

    QuestionDatabace q = new QuestionDatabace();
    String[] answer = new String[q.q.length];
    int count = 0, count2 = 0;

    public QuizAPP(QuestionDatabace q) {
        this.q = q;
    }

    public void ask(Question q, Choices c) {
        System.out.print(q);
        System.out.println(c);
        System.out.print(">> ");
    }

    public boolean check(Question q, String a) {
        if (count < answer.length) {
            answer[count] = a;
            count++;
            if (a.equals(q.getA())) {
                count2++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void PrintResult() {
        System.out.println("\nUserAnswers\tCorrectAnswers");
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i] + "\t\t" + q.q[i].getA());
        }
        System.out.println("TOTAL SCORE: " + count2);
    }

}
