/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bicycle;

/**
 *
 * @author 44869
 */
public class Bicycle {

    private int cadence;
    private int gear;
    private int speed;
    private int id;
    private static int numberOfBicycles = 0;

    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;

        //increment number of Bicycles
        //and assign ID number
        id = numberOfBicycles++;

    }

    // new method to return the ID instance variable
    public int getID() {
        return id;
    }
}

class testBicycle {

    public static void main(String[] args) {
        Bicycle b1 = new Bicycle(100, 200, 5);
        Bicycle b2 = new Bicycle(100, 300, 5);
        Bicycle b3 = new Bicycle(100, 400, 5);
        
        System.out.println(b1.getID());
        System.out.println(b2.getID());
        System.out.println(b3.getID());

    }
}
