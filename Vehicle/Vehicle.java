/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicle;

/**
 *
 * @author 44869
 */
public abstract class Vehicle {
    private int seatingCapacity;
    private double cargoVolume;
    
    public Vehicle(int seating, double cargo){
        seatingCapacity = seating;
        cargoVolume = cargo;
    }
    
    public int getSeating(){
        return seatingCapacity;
    }
    
    public double getCargoVolume(){
        return cargoVolume;
    }
    
    abstract String cargoContainer();
    abstract String description();
    
    /*public abstract int getPassengers();
    public abstract int getNumWheels();*/
   
}
