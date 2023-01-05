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
public class SummativePhrase {

    String Phrase;

    public String getPhrase() {
        return Phrase;
    }

    public void setPhrase(String Phrase) {
        this.Phrase = Phrase;
    }

    public String getConsonants() {
        String c, cl = "", cs = "";
        String p = Phrase.toLowerCase();
        for (int i = 0; i < p.length(); i++) {
            if ("qwrtypsdfghjklzxcvbnm".contains(p.substring(i, i + 1))) {
                c = p.substring(i, i + 1);
                cs = cs + c;
            }
        }
        return cs;
    }

    public String getVoels() {
        String v, vs = "";
        String p = Phrase.toLowerCase();

        for (int m = 0; m < p.length(); m++) {
            if ("aeiou".contains(p.substring(m, m + 1))) {
                v = p.substring(m, m + 1);
                vs = vs + v;
            }
        }
        return vs;
    }

    public String getNumbers() {
        String n, ns = "";
        String p = Phrase.toLowerCase();

        for (int q = 0; q < p.length(); q++) {
            if ("1234567890".contains(p.substring(q, q + 1))) {
                n = p.substring(q, q + 1);
                ns = ns + n;
            }
        }
        return ns;
    }

    public String getLine() {

        String l, ls = "Consonants  Vowels  Numbers" + "\n";
        String nu = getNumbers();
        String vo = getVoels();
        String co = getConsonants();
        int length = vo.length();
        if (nu.length() >= vo.length()) {
            if (co.length() >= nu.length()) {
                length = co.length();
            } else {
                length = nu.length();
            }
        }

        if (co.length() >= vo.length()) {
            if (nu.length() >= co.length()) {
                length = nu.length();
            } else {
                length = co.length();
            }
        } else {
            length = vo.length();
        }

        String num = nu;
        String con = co;
        String vow = vo;

        while (num.length() <= length) {
            num = num + " ";
        }

        while (con.length() <= length) {
            con = con + " ";
        }

        while (vow.length() <= length) {
            vow = vow + " ";
        }
        for (int w = 1; w <= length; w++) {
            l = con.substring(w - 1, w) + "            " + vow.substring(w - 1, w) + "         " + num.substring(w - 1, w);
            ls = ls + l + "\n";
        }
        ls = ls + "\n";
        ls = ls + co.length() + "            " + vo.length() + "         " + nu.length();
        return ls;
    }
}
