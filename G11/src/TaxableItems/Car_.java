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
public class Car_ extends TaxableItem {

    private double discount;

    public Car_(double discount, String name, double taxRate, double originalPrice) {
        super(name, taxRate, originalPrice);
        this.discount = discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public double getDiscount() {
        if (super.getPrice() > 20000) {
            discount = 0.25;
        } else if (super.getPrice() > 15000) {
            discount = 0.15;
        } else {
            discount = 0.1;
        }
        return discount;         
    }
    
    @Override
    public double getPrice(){
        return super.getPrice() * (1 - getDiscount());
    }

    @Override
    public String toString() {
        return super.toString() + "\nCar\n" + "discount: " + getDiscount();
    }

}

class testCar{
    public static void main(String[] args) {
        Car_ t = new Car_(0, "Honda", 0.1, 7000);
        System.out.println(t);
    }
}
