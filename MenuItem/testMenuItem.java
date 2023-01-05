/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuItem;

/**
 *
 * @author 44869
 */
public class testMenuItem {
    public static void main(String[] args) {
        Sandwich club = new Sandwich("Club", 2.75);
        Salad spinach = new Salad("Spinach", 1.25);
        Drink orange = new Drink("Orange", 1.25);

        Sandwich cheese = new Sandwich("Cheese", 2.75);
        Salad coleslaw = new Salad("Coleslaw", 1.25);
        Drink cappuccino = new Drink("Cappuccino", 3.5);

        Sandwich ham = new Sandwich("Ham", 2.75);
        Salad greek = new Salad("Greek", 3.25);
        Drink smoothie = new Drink("Smoothie", 5);

        Trio t1 = new Trio(club, spinach, orange);
        Trio t2 = new Trio(cheese, coleslaw, cappuccino);
        Trio t3 = new Trio(ham, greek, smoothie);

	  System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

    }
    
}
