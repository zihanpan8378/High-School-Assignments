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
public class TaxableItem extends Item {

    
    public TaxableItem(String name, double price, double tax) {
        super(name, price, tax);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + (super.getTax() * super.getPrice());     
    }

    @Override
    public String toString() {
        return super.toString() + "\nPayable Price: $" + getPrice();
    }

}
