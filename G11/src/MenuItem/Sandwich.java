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
public class Sandwich implements MenuItem {

    String name;
    double price;

    Sandwich(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sandwich{" + "name=" + name + ", price=" + price + '}';
    }
    
    


}
