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
public class Money {

    double Rupiah;
    double Exchangerate;
    double KoreanWon;
    double ChineseYuan;

    public void setRupiah(double r) {
        Rupiah = r;
    }

    public double getRupiah() {
        return Rupiah;
    }

    public void setExchangerate(double e) {
        Exchangerate = e;
    }

    public double getExchangerate() {
        return Exchangerate;
    }

    public double getExangedmoney() {
        return Rupiah / Exchangerate;
    }
}
