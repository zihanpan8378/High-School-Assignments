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
public class Palindrome {

    String w;
    int i, q;

    public String getword() {
        return w;
    }

    public void setword(String Word) {
        this.w = Word;
    }
    
    public boolean getanswer() {
        String W = w.replaceAll(" ", "").trim();
        for (i = 1; i <= W.length(); i++) {
            if (W.substring(i-1, i).equals(W.substring(W.length() - (i), W.length() - (i-1)))) {
                q = 1;
            } else {
                q = -1;  
                i += (W.length()+999);
            }
        }
        return q == 1;

    }
}
