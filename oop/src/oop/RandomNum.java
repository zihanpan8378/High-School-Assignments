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
public class RandomNum {
    int Num, Choice;

    public int getNum() {
        return Num;
    }

    public void setNum() {
        this.Num = 1 + (int)(Math.random() * 100);
    }

    public int getChoice() {
        return Choice;
    }

    public void setChoice(int Choice) {
        this.Choice = Choice;
    }
    
    
}
