/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testCoin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Money m = new Money();
        
    System.out.print("Enter amount in Rupiah: ");
       double le = in.nextDouble();
        m.setRupiah(le); 
}
}
