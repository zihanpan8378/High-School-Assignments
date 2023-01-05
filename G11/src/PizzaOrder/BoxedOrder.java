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
public class BoxedOrder {

    String name;
    int num;

    BoxedOrder() {
        name = null;
        num = 0;
    }

    BoxedOrder(String name, int num) {
        this.num = num;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Name of Item: " + getName()
                + "\nNumber of Boxes: " + getNum();
    }

}
