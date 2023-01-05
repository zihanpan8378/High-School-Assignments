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
    int[] bottom;
    int player;
    boolean finish;
    int winner;

    public Connect4() {
        table = new int[6][7];
        bottom = new int[7];
        player = (int) (Math.random() * 2 + 1);
        finish = false;

        for (int i = 0; i < bottom.length; i++) {
            bottom[i] = table.length - 1;
        }
    }

    public void drop(int column) {
        if (bottom[column] >= 0) {
            table[bottom[column]][column] = player;
            if (check() == true) {
                winner = player;
            }
            bottom[column]--;
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
    }

    public boolean check() {
        boolean check = false;
        if (check == false) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length - 3; j++) {
                    if (table[i][j] != 0) {
                        for (int k = 1; k <= 3; k++) {//向右
                            if (table[i][j + k] == table[i][j]) {
                                check = true;
                            } else {
                                check = false;
                                break;
                            }
                        }
                        if (check == true) {
                            break;
                        }
                    }
                }
                if (check == true) {
                    break;
                }
            }
        }
        
        if (check == false) {
            for (int i = 0; i < table.length - 3; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    if (table[i][j] != 0) {
                        for (int k = 1; k <= 3; k++) {//向下
                            if (table[i + k][j] == table[i][j]) {
                                check = true;
                            } else {
                                check = false;
                                break;
                            }
                        }
                        if (check == true) {
                            break;
                        }
                    }
                }
                if (check == true) {
                    break;
                }
            }
        }

        if (check == false) {
            for (int i = 0; i < table.length - 3; i++) {
                for (int j = 0; j < table[0].length - 3; j++) {
                    if (table[i][j] != 0) {
                        for (int k = 1; k <= 3; k++) {//向右下
                            if (table[i + k][j + k] == table[i][j]) {
                                check = true;
                            } else {
                                check = false;
                                break;
                            }
                        }
                        if (check == true) {
                            break;
                        }
                    }
                }
                if (check == true) {
                    break;
                }
            }
        }

        if (check == false) {
            for (int i = 0; i < table.length - 3; i++) {
                for (int j = table[0].length - 1; j >= 3; j--) {
                    if (table[i][j] != 0) {
                        for (int k = 1; k <= 3; k++) {//向左下
                            if (table[i + k][j - k] == table[i][j]) {
                                check = true;
                            } else {
                                check = false;
                                break;
                            }
                        }
                        if (check == true) {
                            break;
                        }
                    }
                }
                if (check == true) {
                    break;
                }
            }
        }
        return check;
    }

}
