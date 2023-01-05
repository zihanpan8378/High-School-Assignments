/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect4;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class tast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter initial money: ");
        int initial = in.nextInt();
        Money m = new Money(initial);
        String choice;
        do{System.out.print("P - play"
                + "\nQ - quit"
                + "\nEnter your choice: ");
        choice = in.next().toUpperCase();
        if(choice.equals("P")){
            if(m.recent<=0){
                System.out.println("you don't have enough money, thank you for playing.");
                break;
            }
            System.out.print("Enter money to risk: ");
            int risk = in.nextInt();
            if(risk>m.recent){
                System.out.println("not enough money!");
            } else{
                m.takeRisk(risk);
                m.newRecent();
            }
            
        } else if (choice.equals("Q")){
            System.out.println("Thank you");
            break;
        } else {
            System.out.println("Please enter again!");
        }}while(!choice.equals("Q"));
    }
}
