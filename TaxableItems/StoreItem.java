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
public class StoreItem {

    private String name;
    private double taxRate;
    private double originalPrice;

    public StoreItem(String name, double taxRate, double originalPrice) {
        this.name = name;
        this.taxRate = taxRate;
        this.originalPrice = originalPrice;
    }
    
    public StoreItem(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getPrice() {
        return originalPrice;
    }

    public void setPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Override
    public String toString() {
        return "StoreItem\n" + "name: " + name + "\ntaxRate: " + taxRate + "\noriginalPrice: " + originalPrice + '\n';
    }
    
    

}
