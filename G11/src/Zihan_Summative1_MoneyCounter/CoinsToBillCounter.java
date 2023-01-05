/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zihan_Summative1_MoneyCounter;

/**
 *
 * @author 44869
 */
public class CoinsToBillCounter extends MoneyCounter {

    private QuarterCounter q;
    private DimeCounter d;
    private NickelCounter n;
    private PennyCounter p;

    CoinsToBillCounter(QuarterCounter q, DimeCounter d, NickelCounter n, PennyCounter p) {
        this.q = q;
        this.d = d;
        this.n = n;
        this.p = p;
    }

    CoinsToBillCounter() {

    }

    @Override
    public double getAmount() {
        return q.getAmount() + d.getAmount() + n.getAmount() + p.getAmount();
    }

    public double getHundreds() {
        return getAmount() / 100;
    }

    public double getFifties() {
        return (getHundreds() - (int) getHundreds()) * 100 / 50;
    }

    public double getTwenties() {
        return (getFifties() - (int) getFifties()) * 50 / 20;
    }

    public double getTens() {
        return (getTwenties() - (int) getTwenties()) * 20 / 10;
    }

    public double getFives() {
        return (getTens() - (int) getTens()) * 10 / 5;
    }

    public double getOneDollarbill() {
        return (getFives() - (int) getFives()) * 5 / 1;
    }

    public double getRemainingpennies() {
        return (getAmount()-(int)getAmount()) * 100;
    }

    @Override
    public String toString() {
        return "Amount: $" + getAmount()
                + "\nHundreds: " + (int) getHundreds()
                + "\nFifties: " + (int) getFifties()
                + "\nTwenties: " + (int) getTwenties()
                + "\nTens: " + (int) getTens()
                + "\nFives: " + (int) getFives()
                + "\nOne Dollar bill: " + (int) getOneDollarbill()
                + "\nRemaining pennies: " + (int) getRemainingpennies();

    }
}
