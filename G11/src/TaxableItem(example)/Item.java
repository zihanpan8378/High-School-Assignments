/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaxableItem;

/**
 *
 * @author maanderson
 */
public class Item {

    private String name;
    private double price;
    private double tax;

    public Item(String name, double price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax/100;
    }
    public Item(){
    }
    
    public void setName(String n){
        name = n;
    }
    public String getName() {
        return name;
    }
    
    public void setTax(double t){
        tax = t/100;
    }
    public double getTax() {
        return tax;
    }
    
    public void setPrice(double p){
        price = p;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String string = "Name: " + getName() + "\n";
        string += "Tax: " + getTax() + "\n";
        string += "Price: $" + getPrice();
        return string;
    }
}
