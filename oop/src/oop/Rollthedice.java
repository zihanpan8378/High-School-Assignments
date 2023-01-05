/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Rollthedice {
    public static void main(String[] args) {
        //declare object scanner and random and variables
        Scanner in = new Scanner(System.in);
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        double Totalmoney = 10000000; 
        double Nowmoney = 10000000;
        
        
        
        while (Nowmoney > 0){
            System.out.println("You have " + Totalmoney + "IDR");
            System.out.print("Place your bet: ");
            double me = in.nextDouble();
            d1.setBet(me);
            
            String answer = "";
            System.out.println("Roll Dice? (Y - Yes or N - No)");
            answer = in.next();
            
            if(answer.equals("yes")){
                d1.setDice();
                d2.setDice();
                d3.setDice();
                System.out.print(d1.getDice());
                System.out.print(d2.getDice());
                System.out.println(d3.getDice());
                
                if ((d1.getDice() == d2.getDice()) && (d1.getDice() == d3.getDice()) && (d1.getDice() == 6)){
                    Totalmoney = Nowmoney + 3 * d1.getBet();
                    
                }
                else if ((d1.getDice() == d2.getDice()) && (d1.getDice() == d3.getDice()) && (d1.getDice() != 6)){
                    Totalmoney = Nowmoney + d1.getBet();
                    
                }
                else{
                    Totalmoney = Nowmoney - d1.getBet();
                    
                }
            Nowmoney = Totalmoney;
            }
            else {
                System.out.print("thank you.");
                Nowmoney = 0;
            }
        }
            
    }
        
        
}

