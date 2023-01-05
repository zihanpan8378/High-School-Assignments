/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect4;

/**
 *
 * @author 44869
 */
public class Connect4 {

    int[][] table;

    Connect4() {
        table = new int[4][4];
    }

    public void set() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = (int) (Math.random() * 2 + 0);
            }

        }
    }

    public void print() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int check() {
        int h = 0, v = 0, d = 0;
        for (int hori = 0; hori < table[0].length; hori++) {
            if (table[hori][0] == table[hori][1]
                    && table[hori][1] == table[hori][2]
                    && table[hori][2] == table[hori][3]) {
                h++;
            }
        }
        for (int vert = 0; vert < table[0].length; vert++) {
            if (table[0][vert] == table[1][vert]
                    && table[1][vert] == table[2][vert]
                    && table[2][vert] == table[3][vert]) {
                v++;
            }
        }
        if (table[0][0] == table[1][1]
                && table[1][1] == table[2][2]
                && table[2][2] == table[3][3]) {
            d++;
        }
        if (table[0][3] == table[1][2]
                && table[1][2] == table[2][1]
                && table[2][1] == table[3][0]) {
            d++;
        }
        return h + v + d;
    }

}

class jiancha {

    public static void main(String[] args) {
        Connect4 c = new Connect4();
        c.set();
        c.print();
        System.out.println(c.check());
    }
}
