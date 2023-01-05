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
public class Formative2 {
    String origin;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getAnswer(){
        String space = " ";
        String b = " " + origin + "";
        String a = "";
        String answer = "";
        
        int letters = b.indexOf(space);
        while(letters != -1){
            a = b.substring(letters, letters+2);
            answer = b.replaceFirst(a, a.toUpperCase());
            b = answer;
            letters = b.indexOf(space, letters+1);
        }
        return answer.trim();
    }
    
}
