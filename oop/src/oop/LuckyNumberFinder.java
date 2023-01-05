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
public class LuckyNumberFinder {
    int num;
    boolean odd,lucky;
    public int getNum(){
       return num;
    }
    public void setNum(int num){
        this.num=num;
    }
    public void setNumRandom(){
        num=(int) (Math.random()*100+1);
    }
    public boolean isOdd(){
       return odd;
    }
    public void setIsOdd(){
    if(num%2!=0)
          odd=true;
        else
            odd=false;
    }
    public void setIsLucky(){
    if(((num%3==0)&&(num%5!=0))||((num%3!=0)&&(num%5==0)))
        lucky=true;
    else
        lucky=false;
    }
    public boolean isLucky(){
    return lucky;
    }
    public String showNumStatus(){
        if(lucky==false&&odd==false)
            return num+" is neither an odd or lucky number";
        if(lucky==true&&odd==true)
            return num+" is lucky and odd";
        if(lucky==false&&odd==true)
            return num+" is odd but not lucky";
        if(lucky==true&&odd==false)
            return num+" is lucky but not odd";
        else
            return num+" is not a valid number!";
    }
}


