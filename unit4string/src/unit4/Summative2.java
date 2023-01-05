/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

/**
 *
 * @author 44869
 */
public class Summative2 {

    String phrase;
    int words;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public String getAnswer() {
        phrase = " " + phrase;
        int space = phrase.indexOf(" ");
        int space2;
        String w = "";
        String a, answer = phrase;

        while (space != -1) {
            w = w + " ";
            space = phrase.indexOf(" ", space + 1);
        }

        if (words >= w.length()) {
            words = words - w.length();
        }

        for (int i = 0; i < words; i++) {
            space = answer.indexOf(" ");
            space2 = answer.indexOf(" ", space + 1);
            a = answer.substring(space, space2);
            answer = answer.substring(space2);
            answer += a;

        }

        return answer.trim();
    }
}
