/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author 44869
 */
public class Coin {
    double tenc;
    double twentyc;
    double fiftyc;
    double oned;
    double twod;
    double fived;
    double tend;

    public double getTenc() {
        return tenc;
    }

    public void setTenc(double tenc) {
        this.tenc = tenc;
    }

    public double getTwentyc() {
        return twentyc;
    }

    public void setTwentyc(double twentyc) {
        this.twentyc = twentyc;
    }

    public double getFiftyc() {
        return fiftyc;
    }

    public void setFiftyc(double fiftyc) {
        this.fiftyc = fiftyc;
    }

    public double getOned() {
        return oned;
    }

    public void setOned(double oned) {
        this.oned = oned;
    }

    public double getTwod() {
        return twod;
    }

    public void setTwod(double twod) {
        this.twod = twod;
    }

    public double getFived() {
        return fived;
    }

    public void setFived(double fived) {
        this.fived = fived;
    }

    public double getTend() {
        return tend;
    }

    public void setTend(double tend) {
        this.tend = tend;
    }
    
    public double getTotal() {
        return tenc * 0.1 + twentyc * 0.2 + fiftyc * 0.5 + oned * 1 + twod * 2 + fived*5+tend*10;
    }   


}
