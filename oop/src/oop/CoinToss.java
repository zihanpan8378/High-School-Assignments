/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author 44869
 */
public class CoinToss {
    int Coin, Times, Guess;

    public int getCoin() {
        return Coin;
    }

    public void setCoin() {
        this.Coin = 1 + (int)(Math.random() * 2);
    }
    
    public int getTimes() {
        return Times;
    }

    public void setTimes(int Times) {
        this.Times = Times;
    }

    

    public int getGuess() {
        return Guess;
    }

    public void setGuess(int Guess) {
        this.Guess = Guess;
    }
    
    
}
