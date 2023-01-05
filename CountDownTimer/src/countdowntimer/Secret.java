/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdowntimer;

/**
 *
 * @author 44869
 */
public class Secret {
    String secret, enter, result = "Correct";
    int num = 0;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
    
    public void check() {
        if(!enter.equals(secret)) {
            result = "incorrect";
        } else {
            result = "Correct";
        }
        num++;
    }
}
