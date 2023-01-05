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
public class Number {
    double Num; 
    int Choice, Answer, Onesplacenumber, Tensplacenumber, 
            Hundredsplacenumber, Thousandsplacenumber;

    public double getNum() {
        return Num;
    }

    public void setNum(double Num) {
        this.Num = Num;
    }

    public int getChoice() {
        return Choice;
    }

    public void setChoice(int Choice) {
        this.Choice = Choice;
    }

    public int getAnswer() {
        return Answer;
    }

    public void setAnswer(int Answer) {
        this.Answer = Answer;
    }
    
    
    
    public void setOnesplacenumber(int Onesplacenumber) {
        this.Onesplacenumber = Onesplacenumber;
    }
    public double getOnesplacenumber(){
        return (int) Math.floor(Num%10);
    }
    
    public void setOTensplacenumber(int Tensplacenumber) {
        this.Tensplacenumber = Tensplacenumber;
    }
    public int getTensplacenumber(){
        return (int) Math.floor((Num/10)%10);
    }
    
    public void setHundredsplacenumber(int Hundredsplacenumber) {
        this.Hundredsplacenumber = Hundredsplacenumber;
    }
    public int getHundredsplacenumber(){
        return (int) Math.floor((Num/100)%10);
    }
    
    public void setThousandsplacenumber(int Thousandsplacenumber) {
        this.Thousandsplacenumber = Thousandsplacenumber;
    }
    public int getThousandsplacenumber(){
        return (int) Math.floor((Num/1000)%10);
    }
    public int getTotalofalldigits(){
        return (int) Math.floor(Num%10) + (int) Math.floor((Num/10)%10) + (int) Math.floor((Num/100)%10) + (int) Math.floor((Num/1000)%10);
    }
    
    
     
}
