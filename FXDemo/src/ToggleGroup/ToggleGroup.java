/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToggleGroup;

import java.text.DecimalFormat;

/**
 *
 * @author 44869
 */
public class ToggleGroup {

    int penny, nickel, dime, quarter;
    DecimalFormat df = new DecimalFormat( "0.00 ");

    public int getPenny() {
        return penny;
    }

    public void setPenny(int penny) {
        this.penny = penny;
    }

    public int getNickel() {
        return nickel;
    }

    public void setNickel(int nickel) {
        this.nickel = nickel;
    }

    public int getDime() {
        return dime;
    }

    public void setDime(int dime) {
        this.dime = dime;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public double total() {
        return getPenny() * 0.01 + getNickel() * 0.05 + getDime() * 0.1 + getQuarter() * 0.25;
    }

    public String toString() {
        return "Total:\t$" + df.format(total());
    }
    
    public static void main(String[] args) {
        ToggleGroup t = new ToggleGroup();
        t.setPenny(1);
        t.setNickel(2);
        t.setDime(3);
        t.setQuarter(4);
        System.out.println(t.toString());
    }

    public Object selectedToggleProperty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
