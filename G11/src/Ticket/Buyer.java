/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

/**
 *
 * @author 44869
 */
public class Buyer {
    String fN, lN, address;
    double postalFee;
    
    Buyer(String fN, String lN, String address, double postalFee){
        this.fN = fN;
        this.lN = lN;
        this.address = address;
        this.postalFee = postalFee;
    }

    public String getfN() {
        return fN;
    }

    public void setfN(String fN) {
        this.fN = fN;
    }

    public String getlN() {
        return lN;
    }

    public void setlN(String lN) {
        this.lN = lN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPostalFee() {
        return postalFee;
    }

    public void setPostalFee(double postalFee) {
        this.postalFee = postalFee;
    }

    @Override
    public String toString() {
        return "Buyer: " + getfN() + " " + getlN() + "\nAddress: " + getAddress() + "\nPostalFee: " + getPostalFee();
    }
    
    
    
    
}
