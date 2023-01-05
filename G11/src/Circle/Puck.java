/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circle;

/**
 *
 * @author 44869
 */
public class Puck extends Disk {//1

    private double weight;//1

    public Puck(double weight, double tickness, double r) {//1
        super(tickness, r);//1
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDivision() {//2
        String division = null;
        if (weight <= 5.5 && weight >= 5) {
            division = "standard";
        } else if (weight <= 4.5 && weight >= 4) {
            division = "youth";
        } else {
            division = "the puck is neither standard nor youth";
        }
        return division;
    }

    public boolean isOfficial() {//2
        return super.getTickness() == 1 && super.getRadius() * 2 == 3;
    }

    /*public boolean isOfficial() {
        boolean official;
        if (super.getTickness() == 1 && super.getRadius() == 1.5) {
            official = true;
        } else {
            official = false;
        }
        return official;
    }*/
    
    @Override
    public String toString() {
        return super.toString() + "\nPuck{" + "weight=" + weight + '}' + "\n" + getDivision() + "\n" + isOfficial();
    }
}
