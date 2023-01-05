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
public class ShoppingCart {

    ShopDatabase db;
    Product[] cart;
    int count = 0;

    ShoppingCart(ShopDatabase db) {
        this.db = db;
        cart = new Product[1000];
    }

    public void addC(int ID) {//add the product with the typed ID to the cart
        int i, j;
        for (i = 0; i < db.p.length; i++) {
            if (db.p[i] != null && db.p[i].getID() == ID) {
                break;
            }
        }
        if (i < db.p.length && db.p[i].stock > 0 && db.p[i] != null) {
            Product product = db.p[i];
            if (count < cart.length) {
                for (j = 0; j < cart.length; j++) {
                    if (cart[j] != null && product.ID == cart[j].ID) {
                        break;
                    }
                }
                if (j < cart.length) {
                    db.p[i].stock--;
                    cart[j].stock = db.p[i].stock;
                    cart[j].quantity++;
                    cart[j].price += product.price;
                } else {
                    db.p[i].stock--;
                    cart[count] = new Product(product.ID, product.name,
                            product.price, product.quantity, product.unit, product.stock);
                    count++;
                }
            } else {
                System.out.println("Out of range");
            }
        } else {
            System.out.println("Item does not exist or has no stock!!");
        }
    }

    public void remove(int ID) {//remove items with the same typed ID, put its stock back
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null && cart[i].getID() == ID) {
                int j;
                for (j = 0; j < db.p.length; j++) {
                    if (db.p[j].ID == ID) {
                        break;
                    }
                }
                db.p[j].stock += cart[i].quantity;
                cart[i] = null;
                for (int k = i; k < cart.length - 1; k++) {
                    cart[k] = cart[k + 1];
                }
            } else {

            }
        }
    }

    public void display(Product[] p) {//display all items the shopping cart, the price here is the total price for that much quantity of products.
        System.out.println("IDNum\tName\tPrice\tQuantity\tUnit\tRemining Stock");
        for (Product p1 : p) {
            if (p1 != null) {
                System.out.println(p1);
            }
        }
        System.out.print("TOTAL: ");
        System.out.println(totalPrice(cart));
    }

    public double totalPrice(Product[] p) {//calculate the total price of the items in the shopping cart
        double total = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                total += p[i].getPrice();
            }
        }
        return total;
    }

    public void pay(double money) {//remove all items in the shopping cart and calculate the change
        if (money >= totalPrice(cart)) {
            double change = money - totalPrice(cart);
            System.out.println("Change: " + new DecimalFormat("0.00").format(change));
            for (int i = 0; i < cart.length; i++) {
                cart[i] = null;
                count = 0;
            }
        } else {
            System.out.println("Not enough");
        }
    }

}
