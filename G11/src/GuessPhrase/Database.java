/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessPhrase;

import java.util.ArrayList;

/**
 *
 * @author 44869
 */
public class Database {

    ArrayList<Phrase> phrase = new ArrayList();
    ArrayList<Phrase> answeredPhrase = new ArrayList();
    int question = 0;

    Database() {
        add(new Phrase("hello world"));
        add(new Phrase("java programming"));
        add(new Phrase("parallel testing"));
        add(new Phrase("user acceptance"));
    }

    public void add(Phrase p) {
        int i, j;
        for (i = 0; i < phrase.size(); i++) {
            if (p.getPhrase().equals(phrase.get(i).getPhrase())) {
                break;
            }
        }
        if (i == phrase.size()) {
            p.trim(p.phrase);
            if (p.check(p.phrase) == true) {
                this.phrase.add(p);
            }
            question++;
        } else {
            System.out.println("\t\tThis phrase is already in the unansered database!");
        }
    }

    public void displayDatabase() {
        System.out.println("\t\tUnanswered: ");
        for (int i = 0; i < phrase.size(); i++) {
            System.out.println("\t\t\t" + phrase.get(i).getPhrase());
        }
        if (answeredPhrase.size() != 0) {
            System.out.println("\t\tAnswered: ");
            for (int i = 0; i < answeredPhrase.size(); i++) {
                System.out.println("\t\t\t" + answeredPhrase.get(i).getPhrase());
            }
        }
    }

    public void remove(String p) {
        int i;
        boolean removed = false;
        for (i = 0; i < phrase.size(); i++) {
            if (phrase.get(i).getPhrase().equals(p)) {
                phrase.remove(i);
                removed = true;
            }
        }

        if (removed == false) {
            System.out.println("\t\tthis phrase doesn't in the database");
        } else {
            System.out.println("\t\tremoved successfully");
            question--;
        }
    }

}
