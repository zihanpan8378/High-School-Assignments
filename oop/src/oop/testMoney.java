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
public class testMoney {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Money m = new Money();

        System.out.print("Enter amount in Rupiah: ");
        double le = in.nextDouble();
        m.setRupiah(le);

        System.out.println("1 - to USD");
        System.out.println("2 - to Korean Won");
        System.out.println("3 - to Chinese Yuan");
        System.out.print("Enter your choice: ");
        int la = in.nextInt();
        {

            System.out.print("Enter exchange rate for that currency: ");
            double lb = in.nextDouble();
            m.setExchangerate(lb);

            if (la == 1) {
                System.out.print(m.getRupiah() + " Rupiah = " + m.getExangedmoney() + " USD");
            }
            if (la == 2) {
                System.out.print(m.getRupiah() + " Rupiah = " + m.getExangedmoney() + " Korean Won");
            }
            if (la == 3) {
                System.out.print(m.getRupiah() + " Rupiah = " + m.getExangedmoney() + " Chinese Yuan");
            }
        }
    }

}
