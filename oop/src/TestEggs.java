
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44869
 */
public class TestEggs {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Eggs e = new Eggs();
        
        System.out.print("Enter number of Eggs: ");
        int ne = input.nextInt();
        e.setNumOfEggs(ne);
        System.out.println("Total Bill is :" + e.getTotalBill());
    }
}
