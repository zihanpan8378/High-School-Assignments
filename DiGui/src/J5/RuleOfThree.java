/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44869
 */
public class RuleOfThree {

    public class Question {

        String question, answer;
        String[] options;
        
        public Question() {
            question = "";
            answer = "";
            options = new String[3];
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

    public RuleOfThree() {
        q = new Question[3];
        score = 0;
        i = 0;
    }

    public void setQuestion() {
        q[0].setQuestion("1 + 1 = ?");;
        q[0].options[0] = "1";
        q[0].options[1] = "2";
        q[0].options[2] = "3";
        q[0].answer = "B";
        q[1].setQuestion("2 - 1 = ?");
        q[1].options[0] = "1";
        q[1].options[1] = "2";
        q[1].options[2] = "3";
        q[1].answer = "A";
        q[2].setQuestion("1 + 2 = ?");
        q[2].options[0] = "1";
        q[2].options[1] = "2";
        q[2].options[2] = "3";
        q[2].answer = "C";
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
        RuleOfThree q = new RuleOfThree();
        System.out.println(q.q[0].question);
    }
}
