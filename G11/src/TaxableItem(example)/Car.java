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
public class Car extends TaxableItem {

    private double discount;

    public Car(String name, double price, double tax) {
        super(name, price, tax);
    }

    public double getDiscount() {
        if (super.getPrice() > 20000) {
            discount = 0.25;
        } else if (super.getPrice() > 15000) {
            discount = 0.15;
        } else if (super.getPrice() <= 15000) {
            discount = 0.1;
        }
        return discount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() - (super.getPrice() * getDiscount());
    }

    @Override
    public String toString() {
        return super.toString() + "\nDiscount: " + getDiscount();
    }
}
