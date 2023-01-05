/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 44869
 */
public class Shuffling {

    public static void main(String[] args) {
        
        String v = "System Fundamentals";
        System.out.println(v);
        System.out.println(shuffle(v));
    }

    public static String shuffle(String w) {
        String word1 = w.substring(0, w.indexOf(" "));
        String word2 = w.substring(w.indexOf(" ")+1);
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
}
