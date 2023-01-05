/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import java.text.DecimalFormat;

/**
 *
 * @author 44869
 */
public class Product {

    int ID, quantity, stock;
    double price;
    String name, unit;
    

    public Product(int ID, String name, double price, int quantity, String unit, int stock) {
        this.ID = ID;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.unit = unit;
        this.stock = stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return ID + "\t" + name + "\t" + new DecimalFormat("0.00").format(price) + "\t" + quantity + "\t\t" + unit + "\t" + stock;
    }

}
