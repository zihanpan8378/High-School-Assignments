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
public class Compval{

    int Num, Choice, Answer;

    public int getNum() {
        return Num;
    }

    public void setNum() {
        this.Num = 0 + (int)(Math.random() * 9);
    }

    public int getChoice() {
        return Choice;
    }

    public void setChoice(int Choice) {
        this.Choice = Choice;
    }
    
    

}
