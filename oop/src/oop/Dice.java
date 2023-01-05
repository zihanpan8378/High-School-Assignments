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
public class Dice {
    int Dice;
    double bet,money;

    public int getDice() {
        return Dice;
    }

    public void setDice() {
        this.Dice = 1 + (int)(Math.random() * 6);
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    
}
