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
public class QuizApp {

    public class Question {

        String question, answer;
        String[] options;

        public Question(String question, String answer, String[] options) {
            this.question = question;
            this.answer = answer;
            this.options = options;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String[] getOptions() {
            return options;
        }

        public void setOptions(String[] options) {
            this.options = options;
        }

    }

    Question[] q;
    int score, i;

    public QuizApp() {
        q = new Question[3];
        score = 0;
        i = 0;
        String[] q1 = {"1", "2", "3"};
        String[] q2 = {"3", "2", "1"};
        String[] q3 = {"3", "1", "2"};
        q[0] = new Question("1 + 1 = ?", "B", q1);
        q[1] = new Question("2 - 1 = ?", "C", q2);
        q[2] = new Question("1 + 2 = ?", "A", q3);
    }

    public String result(String choice) {
        if (choice.equals(q[i].answer)) {
            score++;
            return "Correct";
        } else {
            return "Incorrect";
        }
    }

    public static void main(String[] args) {
        QuizApp q = new QuizApp();
        System.out.println(q.q[q.i].getQuestion());
        System.out.println(q.q[q.i].getOptions()[0]);
    }
}
