/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

/**
 *
 * @author 44869
 */
public class testTaxman_Summative {

    public static void main(String[] args) {
        Taxman_Summative tax = new Taxman_Summative();

        tax.setRange();
        do {tax.setEnter();
            tax.getFactors();
            tax.getTotalFactor();
            if (tax.totalFactor != 0) {
                tax.setPrintFactors();
                System.out.println("\n"+"Your score: " + tax.getUserScore());
                System.out.println("Taxman score: " + tax.getTax());
                System.out.println(tax.getResult());
            }
        } while (tax.totalFactor != 0);
        tax.setFinish();
        tax.setFinalResult();
    }
}
