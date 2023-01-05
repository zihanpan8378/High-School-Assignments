/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaxableItems;

/**
 *
 * @author 44869
 */
public class TaxableItem extends StoreItem {

    //private double payablePrice;

    public TaxableItem(/*double payablePrice, */String name, double taxRate, double originalPrice) {
        super(name, taxRate, originalPrice);
        //this.payablePrice = payablePrice;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * getTaxRate() + super.getPrice();
    }

    /*public void setPayablePrice(double payablePrice) {
        this.payablePrice = payablePrice;
    }*/

    @Override
    public String toString() {
        return super.toString() + "TaxableItem\n" + "payablePrice: " + getPrice();
    }

}

class testTaxableItem {

    public static void main(String[] args) {
        TaxableItem t = new TaxableItem("p", 0.1, 7000);
        System.out.println(t);
    }
}
