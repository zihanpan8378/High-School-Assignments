/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs10finalproject;

import java.util.Random;

/**
 *
 * @author 44869
 */
public class Battleship_bombing {

    Battleship_game bs = new Battleship_game();
    int x, y, pointA = 0, pointB = 0;
    String resultA, resultB, finalResult;
    Random r = new Random();

    public void setBombing() {
        if (bs.set[x][y].equals(bs.ic[0])) {
            bs.set[x][y] = bs.ic[6];
            resultA = "You bombed " + x + "+" + y + "and You Missed";
        } else {
            resultA = "You bombed " + x + "+" + y + "and You Hitted The Target";
            bs.set[x][y] = bs.ic[5];
            pointA += 100;
        }
        x = 0;
        y = 0;
    }

    public void setComputerBombing() {
        x = r.nextInt(10) + 1;
        y = r.nextInt(10) + 1;
        while (bs.set[x][y].equals(bs.ic[5]) || bs.set[x][y].equals(bs.ic[6])) {
            x = r.nextInt(10) + 1;
            y = r.nextInt(10) + 1;
        }
        if (bs.set[x][y].equals(bs.ic[0])) {
            bs.set[x][y] = bs.ic[6];
            resultB = "The Computer Missed";
        } else {
            resultB = "The Computer Hit The Target";
            bs.set[x][y] = bs.ic[5];
            pointB += 100;
        }
        x = 0;
        y = 0;
    }

    public void PrintResult() {
        if (pointA > pointB) {
            finalResult = "You Win The Game!";
        } else if (pointA < pointB) {
            finalResult = "You Lose The Game.";
        } else {
            finalResult = "You Got Same Score With Computer.";
        }
    }
}
