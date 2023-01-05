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
    
    Sandwich san;
    Salad sal;
    Drink dri;

    public Trio(Sandwich a, Salad b, Drink c) {
        san = a;
        sal = b;
        dri = c;
        
        
        /*if(a.getPrice()>b.getPrice()){
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
        }*/
    }

    @Override
    public String getName() {
        name = san.getName() + " / " + sal.getName() + " / " + dri.getName() + " ";
        return name;
    }

    @Override
    public double getPrice() {
        double min = Math.min(Math.min(san.getPrice(), sal.getPrice()), dri.getPrice());  
        price = san.getPrice()+sal.getPrice()+dri.getPrice()-min;
        return price;
    }

    @Override
    public String toString() {
        return "Trio: " + getName()+" | Price: " + getPrice();

    }
    
    

}
