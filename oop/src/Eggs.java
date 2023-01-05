/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44869
 */
public class Eggs {

    int numofEggs;
    double pricePerDozen;

    public int getNumOfEggs() {
        return numofEggs;
    }

    public void setNumOfEggs(int n) {
        numofEggs = n;
    }

    public int getNumOfDozen() {
        return numofEggs / 12;
    }

    public int getExtraEggs() {
        return numofEggs % 12;
    }

    public double getPricePerDozen() {
        if (getNumOfDozen() < 4) {
            pricePerDozen = 0.50;
        } else if (getNumOfDozen() >= 4 && getNumOfDozen() < 6) {
            pricePerDozen = 0.45;
        } else if (getNumOfDozen() >= 6 && getNumOfDozen() < 11) {
            pricePerDozen = 0.40;
        } else if (getNumOfDozen() >= 11) {
            pricePerDozen = 0.35;
        }
        return pricePerDozen;

    }
、
    public double getTotalBill() {
        return getNumOfDozen() * getPricePerDozen() + (1 / 12 * getPricePerDozen() * getExtraEggs());
    }
}
