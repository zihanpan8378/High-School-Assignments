/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxOfNumOrAlpha;

import java.util.ArrayList;

/**
 *
 * @author 44869
 */
public class BoxOfNumOrAlpha {

    public static void main(String[] args) {
        RNum r = new RNum();
        RVowel v = new RVowel();
        BoxTracker bt = new BoxTracker();
        bt.addBox(new Box(3, 3, "v"));
        bt.addBox(new Box(4, 5, "v"));
        bt.addBox(new Box(4, 4, "n"));
        bt.addBox(new Box(5, 5, "n"));
        bt.printBoxes();
    }

}

class RNum {

    int num;

    RNum() {
        setNum();
    }

    public int getNum() {
        return num;
    }

    public void setNum() {
        num = (int) (Math.random() * 5 + 1);
    }

}

class RVowel {

    char alpha;

    String list = "aeiou";
    
    RVowel() {
        setAlpha();
    }
    
    public char getAlpha() {
        return alpha;
    }

    public void setAlpha() {
        alpha = list.charAt((int) (Math.random() * 5 + 0));
    }
}

class Box {

    RNum[][] nums;
    RVowel[][] alphas;
    int row, col;
    String choice;

    Box(int i, int j, String choice) {
        this.row = i;
        this.col = j;
        this.choice = choice;
        nums = new RNum[i][j];
        alphas = new RVowel[i][j];
    }

    public void addIndexNum() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (choice.equals("n")) {
                    nums[i][j] = new RNum();
                } else if (choice.equals("v")) {
                    alphas[i][j] = new RVowel();
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (choice.equals("n")) {
                    System.out.print(nums[i][j].getNum() + " ");
                } else if (choice.equals("v")) {
                    System.out.print(alphas[i][j].getAlpha() + " ");
                }
            }
            System.out.println("");
        }
    }

}

class BoxTracker {

    ArrayList<Box> b = new ArrayList();

    public void addBox(Box b) {
        b.addIndexNum();
        this.b.add(b);

    }

    public void printBoxes() {
        for (int i = 0; i < b.size(); i++) {
            b.get(i).print();
            System.out.println("");
        }
    }
}
