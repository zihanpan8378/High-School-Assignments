/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class TicTacToe {

    String[][] table;
    int player;
    Scanner in = new Scanner(System.in);
    boolean result;

    TicTacToe() {
        table = new String[3][3];
        player = (int) (Math.random() * 2 + 1);
        result = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = "_";
            }
        }
        System.out.println("Player 1: X\n"
                + "Player 2: O\n"
                + "_  _  _\n"
                + "_  _  _\n"
                + "_  _  _\n"
                + "\n"
                + "Start…");
    }

    public void playerAction() {
        String xo = "_";
        int row = 0, column = 0;
        if (player == 1) {
            System.out.println("Player 1");
            xo = "X";
            player = 2;
        } else if (player == 2) {
            System.out.println("Player 2");
            xo = "O";
            player = 1;
        }
        boolean check = true;
        do {
            check = true;
            System.out.print("Enter row index: ");
            do {
                row = in.nextInt();
                if (row > table.length || row < 0) {
                    System.out.print("out of range, please enter row index: ");
                }
            } while (row > table.length || row < 0);
            System.out.print("Enter column index: ");
            do {
                column = in.nextInt();
                if (column > table[0].length || column < 0) {
                    System.out.print("out of range, please enter lolumn index: ");
                }
            } while (column > table[0].length || column < 0);
            if (table[row][column].equals("_")) {
                table[row][column] = xo;
            } else {
                check = false;
                System.out.println("there is already an index here! please do again!");
            }
        } while (check == false);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void check() {
        boolean horizontal = false, vertical = false, diagonal = false;

        for (int i = 0; i < table.length; i++) {
            horizontal = true;
            for (int j = 0; j < table[0].length - 1; j++) {
                if (horizontal == true && table[i][j].equals(table[i][j + 1]) && !table[i][j].equals("_")) {
                    horizontal = true;
                } else {
                    horizontal = false;
                }
            }
            if (horizontal == true) {
                break;
            }
        }

        for (int j = 0; j < table[0].length; j++) {
            vertical = true;
            for (int i = 0; i < table.length - 1; i++) {
                if (vertical == true && table[i][j].equals(table[i + 1][j]) && !table[i][j].equals("_")) {
                    vertical = true;
                } else {
                    vertical = false;
                }
            }
            if (vertical == true) {
                break;
            }
        }

        if (((table[0][0].equals(table[1][1]) && table[0][0].equals(table[2][2]))
                || (table[0][2].equals(table[1][1]) && table[0][2].equals(table[1][2])))
                && !table[1][1].equals("_")) {
            diagonal = true;
        }

        if (horizontal == true || vertical == true || diagonal == true) {
            result = true;
            if (player == 1) {
                System.out.println("Winner is player 2!");
            } else if (player == 2) {
                System.out.println("winner is player 1!");
            }
        }
        
        boolean check = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if(!table[i][j].equals("_")){
                    check = false;
                }
            }
        }
        if(check == false && result == false){
            System.out.println("no winner!");
        }
    }
}
