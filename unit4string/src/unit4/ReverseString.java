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
public class ReverseString {

    String original;

    public void setString(String s) {
        original = s;
    }

    public String getString() {
        return original;
    }

    public String getReverse() {
        int i;
        String r, l;
        r = "";
        for (i = original.length(); i > 0; i--) {
            l = original.substring(i - 1, i);
            r += l;
            l = "";
        }
        return r;
    }
}
