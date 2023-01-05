/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessPhrase;

/**
 *
 * @author 44869
 */
public class Phrase {

    String phrase;

    Phrase(String phrase) {
        this.phrase = phrase;
    }

    public void trim(String phrase) {
        phrase = phrase.trim();
        phrase = phrase.toLowerCase();
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public boolean check(String phrase) {
        if (phrase.contains(" ")) {
            if (phrase.indexOf(" ") == phrase.lastIndexOf(" ")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
