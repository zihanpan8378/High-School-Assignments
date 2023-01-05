/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DieNow;

import java.util.Scanner;

/**
 *
 * @author 40474
 */
public class Game {

    public static void main(String[] args) {
        DieNow d = new DieNow();
        int n;
        Scanner input = new Scanner(System.in);
        while (d.isGoing()) {
            //p1
            d.println();
            System.out.println("P1's turn:");
            System.out.println("Enter direction to move:");
            System.out.println("1:right 2:down 3:left 4:up 0:stay");
            n = input.nextInt();
            while (n != 0) {
                d.movePlayer(1, n);
                d.println();
                n = input.nextInt();
            }
            System.out.println("Connect:");
            n = input.nextInt();
            while (d.connect(1, n)==false) {
                System.out.println("Cannot Connect");
                n = input.nextInt();
            }
            //p2
            if (d.isGoing()) {
                d.println();
                System.out.println("P2's turn:");
                System.out.println("Enter direction to move:");
                System.out.println("1:right 2:down 3:left 4:up 0:stay");
                n = input.nextInt();
                while (n != 0) {
                    d.movePlayer(2, n);
                    d.println();
                    n = input.nextInt();

                }
                System.out.println("Connect:");
                n = input.nextInt();
                while (d.connect(2, n)==false) {
                    System.out.println("Cannot Connect");
                    n = input.nextInt();
                }
            }
        }
        
        int x[] = d.winner();
        System.out.println("Player " + x[0] + " Wins!");
    }

}
