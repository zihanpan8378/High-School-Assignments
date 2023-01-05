/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessPhrase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Game implements User {

    Database d = new Database();
    Scanner in = new Scanner(System.in);
    int totalPoint, guess, random;

    Game() {
        totalPoint = 0;
        guess = 0;
    }

    public static String shuffle(Phrase p) {
        String word1 = p.getPhrase().substring(0, p.getPhrase().indexOf(" "));
        String word2 = p.getPhrase().substring(p.getPhrase().indexOf(" ")+1);
        ArrayList<Character> chars = new ArrayList();
        for (int i = 0; i < word1.length(); i++) {
            chars.add(i, word1.charAt(i));
        }
        Collections.shuffle(chars);
        String newWord = "";
        for (Character c : chars) {
            newWord += c;
        }
        newWord+=" ";
        ArrayList<Character> chars2 = new ArrayList();
        for (int i = 0; i < word2.length(); i++) {
            chars2.add(i, word2.charAt(i));
        }
        Collections.shuffle(chars2);
        for (Character c : chars2) {
            newWord += c;
        }
        return newWord;
    }

    /*public String shuffle(Phrase p) {
        int words = 1;
        for (int i = 0; i < p.getPhrase().length(); i++) {
            if (p.getPhrase().substring(i, i + 1).equals(" ")) {
                words++;
            }
        }
        p.phrase += " ";
        System.out.println(words);
        String newWord = "";
        ArrayList<Character> chars = new ArrayList();

        ArrayList<String> word = new ArrayList();
        for (int i = 0; i < words; i++) {
            word.add(p.phrase.substring(0, p.phrase.indexOf(" ")));
            p.phrase = p.getPhrase().substring(p.getPhrase().indexOf(" ") + 1);
            System.out.println(word.get(i));
        }
        for (int i = 0; i < words; i++) {
            for (int j = 0; j < word.get(i).length(); j++) {
                chars.add(word.get(i).charAt(j));
            }
            Collections.shuffle(chars);
            for (Character c : chars) {
                newWord += c;
            }
            newWord += " ";
            int k = chars.size();
            for (int j = 0; j < k; j++) {
                chars.remove(chars.get(0));
            }
        }
        return newWord.substring(0, newWord.lastIndexOf(" "));
    }*/

    public Phrase random() {
        random = (int) (Math.random() * d.phrase.size() + 0);
        return d.phrase.get(random);
    }

    public void guess() {
        if (d.phrase.size() != 0) {
            int remain;
            String s = shuffle(random());
            System.out.print("\t\t>> " + s + "?  ");
            String a = in.nextLine();
            String answer = "";
            guess++;
            remain = d.question - guess;
            if (answer.equals(d.phrase.get(random).phrase) || a.equals(d.phrase.get(random).phrase)) {
                totalPoint++;
                System.out.println("\t\tCorrect!");
            } else {
                System.out.println("\t\tWrong answer!");
            }
            d.answeredPhrase.add(d.phrase.get(random));
            d.phrase.remove(d.phrase.get(random));

            if (remain <= (d.question / 2)) {
                System.out.println("\t\t" + remain + " phrases left to guess...");
            }
            System.out.println("\t\tTotal points: " + totalPoint);
        } else {
            System.out.println("\t\tThere isn't phrase in the database!");
        }
    }
}
