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
public class testTrioOrder {

    public static void main(String[] args) {
        TrioOrders trio = new TrioOrders();
        trio.t = new Trio[5];

        Sandwich club = new Sandwich("Club", 2.75);
        Salad spinach = new Salad("Spinach", 1.25);
        Drink orange = new Drink("Orange", 1.25);

        Sandwich cheese = new Sandwich("Cheese", 2.75);
        Salad coleslaw = new Salad("Coleslaw", 1.25);
        Drink cappuccino = new Drink("Cappuccino", 3.5);

        Sandwich ham = new Sandwich("Ham", 2.75);
        Salad greek = new Salad("Greek", 3.25);
        Drink smoothie = new Drink("Smoothie", 5);

        Sandwich chicken = new Sandwich("Chicken", 2.75);
        Salad caesar = new Salad("Caesar", 2.5);

        trio.add(new Trio(club, spinach, orange));
        trio.add(new Trio(cheese, coleslaw, cappuccino));
        trio.add(new Trio(chicken, caesar, orange));
        trio.add(new Trio(ham, greek, smoothie));
        trio.add(new Trio(chicken, greek, cappuccino));

        System.out.println("Print");
        trio.printTrioOrders(trio.t);

        System.out.println("getTrioOrderWithDrink");
        trio.printTrioOrders(trio.getTrioOrderWithDrink("Orange"));

        System.out.println("getOrdersFromTo");
        trio.printTrioOrders(trio.getOrdersFromTo(1, 2));
    }
}
