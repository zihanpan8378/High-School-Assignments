/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceia;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 44869
 */
public class Account {

    private final String username;
    private final int wins;
    private final int losses;

    public Account(String username, int wins, int losses) {    
        this.username = username;
        this.wins = wins;
        this.losses = losses;
    }

    public String getUsername() {
        return username;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
    
    
}
