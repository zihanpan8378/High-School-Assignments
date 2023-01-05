/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CookieOrder;

/**
 *
 * @author 44869
 */
public class CookieOrder {

    String variety;
    int numBoxes;
    
    /**
     * Constructs a new CookieOrder object.
     */
    public CookieOrder(String variety, int numBoxes) {
        /* implementation not shown  */
        this.variety = variety;
        this.numBoxes = numBoxes;
    }

    /**
     * @return the variety of cookie being ordered
     */
    public String getVariety() {
        return variety;
        /* implementation not shown  */
    }

    /**
     * @return the number of boxes being ordered
     */
    public int getNumBoxes() {
        return numBoxes;
        /* implementation not shown  */
    }

// There may be instance variables, constructors, and methods that are not shown.
}
