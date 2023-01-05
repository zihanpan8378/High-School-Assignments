/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PizzaOrder;

/**
 *
 * @author 44869
 */
public class PizzaOrder extends BoxedOrder implements Priceable {

    double pBox, pDelivery = 0, totalPrice;

    PizzaOrder(String name, int num, double pBox) {
        super(name, num);
        this.pBox = pBox;
    }

    public boolean getDeliveryRemarks() {
        if (super.getNum() >= 5) {
            return false;
        } else {
            pDelivery = 3.00;
            return true;
        }
    }

    public double getpBox() {
        return pBox;
    }

    public void setpBox(double pBox) {
        this.pBox = pBox;
    }

    @Override
    public double getTotalPrice() {
        getDeliveryRemarks();
        return getpBox() * super.getNum() + pDelivery;
    }

    @Override
    public String toString() {
        /*return super.toString()
                + "\nPrice per Box: " + pBox
                + "\nDelivery: " + getDeliveryRemarks()
                + "\nTotal Price: " + getTotalPrice();*/
        return getName() + "\t"
                + getNum() + "\t\t"
                + getpBox() + "\t\t"
                + getTotalPrice();
    }

}

class testPizzaOrder {

    public static void main(String[] args) {
        PizzaOrder p = new PizzaOrder("Pepperoni", 5, 8.00);
        System.out.println(p);
    }
}
