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
public class MasterOrder {

    private CookieOrder[] orders;
    int count;
    String string = "";

    public MasterOrder() {
        orders = new CookieOrder[5];
        count = 0;

    }

    public void addOrder(CookieOrder theOrder) {
        if (count < orders.length) {
            orders[count] = theOrder;
            count++;
        }
    }

    public void displayOrders() {
        for (CookieOrder co : orders) {
            if (co != null) {
                System.out.println(co.getVariety());
                System.out.println(co.getNumBoxes());
            }
        }

    }

    public int getTotalBoxes() {
        int sum = 0;
        for (CookieOrder co : orders) {
            if (co != null) {
                sum += co.getNumBoxes();
            }

        }

        return sum;
    }

    /*public int removeVariety(String cookieVar) {
        
        int num = 0;
        //string = "";
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getVariety().equals(cookieVar)) {
                num += orders[i].getNumBoxes();
                orders[i].numBoxes = 0;
                //orders[i].variety = "";
            } else {
                //string += orders[i].getVariety() + "\n" + orders[i].getNumBoxes() + "\n";
            }

        }
        return num;
    }*/
    public int removeVariety(String cookieVar) {//claim the method
        int n = 0;//method variable - number of boxes
        int length = orders.length;//method variable - the length of the orders array
        int k;//method variable - 
        for (k = 0; k < orders.length; k++) {//use a for loop to work on the array
            if (orders[k] != null && orders[k].getVariety().equals(cookieVar)) {//check each index of the array that is there some variety with "cookieVar"
                n += orders[k].getNumBoxes();//add the boxes of cookies that have same variety with "cookieVar" together
                break;//stop the loop
                //"bteak" should be deleted, if not, this method can only remove the first index which have variety with "cookieVar"
            }//find the first index which has the same variety with "cookieVar" 

        }
        if (k < length) {//check that is orders[k] the last index of the orders array
            length = length - 1;
            for (int i = k; i < length; i++) {//work on the loop for each indexes later than k
                orders[i] = orders[i + 1];//move all indexes to the before one
            }
        }
        return n;//return the total boxes of cookies that have same variety with "cookieVar"
    }

    /*public String getInitialString() {
        for (int i = 0; i < orders.length; i++) {
            string += orders[i].getVariety() + "\n" + orders[i].getNumBoxes() + "\n";

        }
        return string;
    }

    @Override
    public String toString() {
        return string;
    }*/
}

class testMasterOrder {

    public static void main(String[] args) {
        MasterOrder goodies = new MasterOrder();
        goodies.addOrder(new CookieOrder("Chocolate Chip", 1));
        goodies.addOrder(new CookieOrder("Shortbread", 5));
        goodies.addOrder(new CookieOrder("Macaroon", 2));
        goodies.addOrder(new CookieOrder("Chocolate Chip", 3));
        //goodies.getInitialString();
        System.out.println(goodies);
        System.out.println("Total boxes: " + goodies.getTotalBoxes());

        System.out.println("Removed: " + goodies.removeVariety("Chocolate Chip") + "\n");
        System.out.println(goodies);
        System.out.println("Total boxes: " + goodies.getTotalBoxes());

    }
}
