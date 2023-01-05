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
public class TrioOrders {

    Trio[] t;
    int count = 0;

    public void add(Trio trio) {
        if (count < t.length) {
            t[count] = trio;
            count++;
        } else {
            System.out.println("Out of range");
        }
    }

    public Trio[] getTrioOrderWithDrink(String dk) {
        Trio[] array = new Trio[t.length];
        int n = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] != null && t[i].dri.getName().equals(dk)) {
                array[n] = t[i];
                n++;
            }
        }
        return array;
    }

    public Trio[] getOrdersFromTo(int start, int end) {
        Trio[] array = new Trio[t.length];
        int n = 0;
        if (end >= t.length) {
            System.out.println("Out of Range");
        } else {
            for (int i = start; i <= end; i++) {
                array[n] = t[i];
                n++;
            }
        }
        return array;
    }

    public void printTrioOrders(Trio[] trio) {
        for (int i = 0; i < trio.length; i++) {
            if (trio[i] != null) {
                System.out.println(trio[i]);
            }
        }
    }

}
