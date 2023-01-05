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
public class Car extends Vehicle{
    public Car(int seating, double trunkSpace){
        super(seating, trunkSpace);
    }
    
    @Override
    public String cargoContainer(){
        String cargoArea;
        
        cargoArea = "Trunk space is " + super.getCargoVolume();
        return cargoArea;
    }
    
    @Override
    public String description(){
        String car = "This car can seat " + super.getSeating() + " passengers.\n";
        car += "The car has a cargo colume of " + super.getCargoVolume() + ".\n";
        return car;
    }
    
    /*private String type;

    public Car(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    //@Override
    public int getPassengers(){
        return 0;
    }
    //@Override
    public int getNumWheels(){
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" + "type=" + type + '}';
    }*/
    
}
