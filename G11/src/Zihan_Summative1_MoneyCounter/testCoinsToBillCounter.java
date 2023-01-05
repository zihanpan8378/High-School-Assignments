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
public class testCoinsToBillCounter {

    public static void main(String[] args) {
        PennyCounter pc = new PennyCounter(110);
        NickelCounter nc = new NickelCounter(100);
        DimeCounter dc = new DimeCounter(100);
        QuarterCounter qc = new QuarterCounter(100);

        CoinsToBillCounter ctc = new CoinsToBillCounter(qc, dc, nc, pc);
        System.out.println("Printing the object itself...");
        System.out.println(ctc);

        PennyCounter pc1 = new PennyCounter(25);
        NickelCounter nc1 = new NickelCounter(250);
        DimeCounter dc1 = new DimeCounter(250);
        QuarterCounter qc1 = new QuarterCounter(2500);
        CoinsToBillCounter ctc1 = new CoinsToBillCounter(qc1, dc1, nc1, pc1);

        System.out.println("\n\n\n\nPrinting results of individual methods...");
        System.out.println("Amount = " + ctc1.getAmount());
        System.out.println("Hundreds = " + (int) ctc1.getHundreds());
        System.out.println("Fifties = " + (int) ctc1.getFifties());
        System.out.println("Twenties = " + (int) ctc1.getTwenties());
        System.out.println("Tens = " + (int) ctc1.getTens());
        System.out.println("Fives = " + (int) ctc1.getFives());
        System.out.println("One dollar bill = " + (int) ctc1.getOneDollarbill());
        System.out.println("Remaining Pennies = " + (int) ctc1.getRemainingpennies());

    }
}
