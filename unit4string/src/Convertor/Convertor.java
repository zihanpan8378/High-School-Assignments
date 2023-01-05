/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Convertor;

/**
 *
 * @author 44869
 */
public class Convertor {

    double exchangeRate[], txtFrom;
    //int from , target ;

    public void setTxtFrom(double txtFrom) {
        this.txtFrom = txtFrom;
    }
    
    public void setExchangeRate() {
        exchangeRate = new double[5];
        exchangeRate[0] = 1;
        exchangeRate[1] = 1;
        exchangeRate[2] = 1.23;
        exchangeRate[3] = 0.16;
        exchangeRate[4] = 0.000073;
    }
    
    
    
    public double getResult(int target, int from) {
        
        return (txtFrom / exchangeRate[from]) * exchangeRate[target];
    }

}
