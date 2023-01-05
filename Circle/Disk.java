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
public class Disk extends Circle {//1

    private double tickness;//1

    public Disk(double tickness, double radius) {
        super(radius);//1
        this.tickness = tickness;
    }

    public double getTickness() {
        return tickness;
    }

    public void setTickness(double tickness) {
        this.tickness = tickness;
    }

    public double getVolume() {//1
        return super.getArea() * getTickness();//1
    }

    @Override
    public String toString() {
        return super.toString() + "\nDisk{" + "tickness=" + tickness + '}' + "valume=" + getVolume();
    }

}
