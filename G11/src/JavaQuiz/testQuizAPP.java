/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaQuiz;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testQuizAPP {

    public static void main(String[] args) {
        Question[] q = new Question[5];
        Choices[] c = new Choices[5];
        q[0] = new Question("What is 1+1", "a");
        q[1] = new Question("What is 2+2", "b");
        q[2] = new Question("What is 3+3", "c");
        q[3] = new Question("What is 4+4", "b");
        q[4] = new Question("What is 5+5", "c");
        c[0] = new Choices("2", "3", "4");
        c[1] = new Choices("3", "4", "7");
        c[2] = new Choices("4", "5", "6");
        c[3] = new Choices("1", "8", "3");
        c[4] = new Choices("2", "3", "10");
        QuestionDatabace qdb = new QuestionDatabace(q, c);
        QuizAPP app = new QuizAPP(qdb);
        Scanner in = new Scanner(System.in);
        int choice;

        System.out.println("1 - Start Quiz"
                + "\n0 - Quit");
        choice = in.nextInt();

        if (choice == 1) {
            System.out.println("Starting...");
            for (int i = 0; i < app.q.q.length; i++) {
                if (app.q.q[i] != null && app.q.c[i] != null) {
                    System.out.print("\n" + (i + 1) + ". ");
                    app.ask(app.q.q[i], app.q.c[i]);
                    String answer = in.next();
                    app.check(app.q.q[i], answer);
                }
            }
            app.PrintResult();
        } else if (choice == 0) {
            System.out.println("Thank you...");
        } else {
            System.out.println("Wrong choice, try again...");
        }
    }
}
