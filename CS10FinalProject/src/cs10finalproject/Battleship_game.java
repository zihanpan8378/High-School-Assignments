/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs10finalproject;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author 44869
 */
public class Battleship_game extends javax.swing.JFrame {

    ImageIcon[][] set = new ImageIcon[10][10], set_ = new ImageIcon[10][10];
    ImageIcon[] ic = new ImageIcon[10];
    int x, y, image, direction, type, pointA = 0, pointB = 0, roundsRemain = 15;
    int[] remain = {0, 1, 2, 3, 4};
    Random r = new Random();
    String outRange, resultA, resultB, finalResult;

    public void setEmpty() {
        for (int i = 0; i < 10; i++) {
            for (int q = 0; q < 10; q++) {
                set[i][q] = ic[0];
            }
        }
    }

    public void setImage() {
        ic[0] = new ImageIcon(getClass().getResource("/cs10finalproject/images/0.jpg"));
        ic[1] = new ImageIcon(getClass().getResource("/cs10finalproject/images/head1.jpeg"));
        ic[2] = new ImageIcon(getClass().getResource("/cs10finalproject/images/head2.jpeg"));
        ic[3] = new ImageIcon(getClass().getResource("/cs10finalproject/images/head3.jpeg"));
        ic[4] = new ImageIcon(getClass().getResource("/cs10finalproject/images/head4.jpeg"));
        ic[5] = new ImageIcon(getClass().getResource("/cs10finalproject/images/body1.jpeg"));
        ic[6] = new ImageIcon(getClass().getResource("/cs10finalproject/images/body2.jpeg"));
        ic[7] = new ImageIcon(getClass().getResource("/cs10finalproject/images/miss.png"));
        ic[8] = new ImageIcon(getClass().getResource("/cs10finalproject/images/hit.png"));
        ic[9] = new ImageIcon(getClass().getResource("/cs10finalproject/images/Results.png"));
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setShipHead() {
        outRange = "";
        if (set[x][y].equals(ic[0]) && x >= 0 && x <= 9 && y >= 0 && y <= 9 && remain[type] != 0) {
            set[x][y] = ic[direction];
            remain[type]--;
        } else {
            if(remain[type] == 0){
                outRange = "already setted or incorrect selection";
            }else{
            outRange = "the ship is out of range";}
            System.out.println("out"+type);
        }
    }

    public void setShipBody() {
        if (!outRange.equals("the ship is out of range")&&!outRange.equals("already setted or incorrect selection")) {
            int j = 4 - type;

            for (int i = 1; i <= j; i++) {
                if (direction == 2) {
                    if (!(x >= 0 && x <= 9 && y - i >= 0 && y - i <= 9 && set[x][y - i].equals(ic[0]))) {
                        outRange = "the ship is out of range";
                    }
                }
                if (direction == 1) {
                    if (!(x >= 0 && x <= 9 && y + i >= 0 && y + i <= 9 && set[x][y + i].equals(ic[0]))) {
                        outRange = "the ship is out of range";
                    }
                }
                if (direction == 4) {
                    if (!(x + i >= 0 && x + i <= 9 && y >= 0 && y <= 9 && set[x + i][y].equals(ic[0]))) {
                        outRange = "the ship is out of range";
                    }
                }
                if (direction == 3) {
                    if (!(x - i >= 0 && x - i <= 9 && y + i >= 0 && y + i <= 9 && set[x - i][y].equals(ic[0]))) {
                        outRange = "the ship is out of range";
                    }
                }
            }
            if (!outRange.equals("the ship is out of range")&&!outRange.equals("already setted or incorrect selection")) {
                for (int i = 1; i <= j; i++) {
                    if (direction == 1) {
                        set[x][y + i] = ic[6];
                    }
                    if (direction == 2) {
                        set[x][y - i] = ic[6];
                    }
                    if (direction == 4) {
                        set[x + i][y] = ic[5];
                    }
                    if (direction == 3) {
                        set[x - i][y] = ic[5];
                    }
                }
            } else {
                set[x][y] = ic[0];
                remain[type]++;
            }
        }
    }

    public void FinishSetting() {
        for (int i = 0; i < 10; i++) {
            for (int q = 0; q < 10; q++) {
                set_[i][q] = set[i][q];
            }
        }
    }

    public void setRandom() {
        x = r.nextInt(9) + 0;
        y = r.nextInt(9) + 0;
        direction = r.nextInt(4) + 1;
        type = r.nextInt(4) + 1;
    }

    public void setComputer() {
        while (remain[1] > 0 || remain[2] > 0 || remain[3] > 0 || remain[4] > 0) {
            setRandom();
            setShipHead();
            setShipBody();
        }
    }

    public void setBombing() {
        if (!(set[x][y].equals(ic[7]) || set[x][y].equals(ic[8]))) {
            if (set[x][y].equals(ic[0])) {
                set[x][y] = ic[7];
                resultA = "You Missed";
            } else {
                resultA = "You Hitted The Target";
                set[x][y] = ic[8];
                pointA += 100;
            }
            
            outRange = "0";
        } else {
            outRange = "1";
        }
    }

    public void setComputerBombing() {
        if (outRange.equals("0")) {
            x = r.nextInt(9) + 0;

            y = r.nextInt(9) + 0;
            while (set_[x][y].equals(ic[7]) || set_[x][y].equals(ic[8])) {
                x = r.nextInt(9) + 0;
                y = r.nextInt(9) + 0;
            }
            if (set_[x][y].equals(ic[0])) {
                set_[x][y] = ic[7];
                resultB = "The Computer Missed";
            } else {
                resultB = "The Computer Hit The Target";
                set_[x][y] = ic[8];
                pointB += 100;
            }
            x = 0;
            y = 0;
            roundsRemain--;
        } 
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
