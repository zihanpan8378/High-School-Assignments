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
public class Trio implements MenuItem {

    String name = "";
    double price = 0;

    Trio(Sandwich a, Salad b, Drink c) {
        name += a.getName() + " / " + b.getName() + " / " + c.getName() + " / ";
        if(a.getPrice()>b.getPrice()){
            if(b.getPrice()>c.getPrice()){
                price += a.getPrice()+b.getPrice();
            }else {
                price += a.getPrice()+c.getPrice();
            }
        }else{
            if(a.getPrice()>c.getPrice()){
                price += b.getPrice()+a.getPrice();
            }else {
                price += b.getPrice()+c.getPrice();
            }
        }
        
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
        return "Trio: " + getName()+" | Price: " + getPrice();

    }
    
    

}
