/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DieNow;

import javax.swing.ImageIcon;

/**
 *
 * @author 40474
 */
public class DieNow {

    private int[][] n = new int[13][13];
    private int p1r, p1c, p2r, p2c, rules;
    private boolean[][] f = new boolean[13][13];
    private boolean going;
    private String p1n, p2n;

    /**
     * pre: none 
     * post: set player 1's name
     *
     * @param p1n is the name for player 1
     */
    public void setP1n(String p1n) {
        this.p1n = p1n;
    }

    /**
     * pre: none 
     * post: set player 2's name
     *
     * @param p2n is the name for player 2
     */
    public void setP2n(String p2n) {
        this.p2n = p2n;
    }

    /**
     * pre: none 
     * post: return player 1's name
     */
    public String getP1n() {
        return p1n;
    }

    /**
     * pre: none 
     * post: return player 2's name
     */
    public String getP2n() {
        return p2n;
    }

    /**
     * pre: none 
     * post: initiate class and variable values
     */
    public DieNow() {
        n = new int[13][13];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                f[i][j] = true;
                if (i % 2 == 0 && j % 2 == 0) {
                    n[i][j] = 1;
                } else {
                    if (i == 0 || j == 0 || i == 12 || j == 12) {
                        n[i][j] = -1;
                    } else {
                        n[i][j] = 0;
                    }
                }
            }
        }
        p1r = 1;
        p1c = 1;
        p2r = 11;
        p2c = 11;
        n[1][1] = 9;
        n[11][11] = 9;
        going = true;
        rules = 1;
    }

    /*
    * pre: none
    * post: clear game board
     */
    public void reset() {
        n = new int[13][13];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                f[i][j] = true;
                if (i % 2 == 0 && j % 2 == 0) {
                    n[i][j] = 1;
                } else {
                    if (i == 0 || j == 0 || i == 12 || j == 12) {
                        n[i][j] = -1;
                    } else {
                        n[i][j] = 0;
                    }
                }
            }
        }
        p1r = 1;
        p1c = 1;
        p2r = 11;
        p2c = 11;
        n[1][1] = 9;
        n[11][11] = 9;
        going = true;
    }

    /**
     * pre: game is going 
     * post: player connects to the wall
     *
     * @param: player is a number representing player's turn
     * @param: facing, the direction of the player
     */
    public boolean connect(int player, int facing) {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                f[i][j] = true;
            }
        }
        int r, c, a, b;
        r = 0;
        c = 0;
        if (facing == 1) {
            c = 1;
        } else if (facing == 2) {
            r = 1;
        } else if (facing == 3) {
            c = -1;
        } else if (facing == 4) {
            r = -1;
        }
        if (player == 1) {
            a = p1r + r;
            b = p1c + c;
        } else {
            a = p2r + r;
            b = p2c + c;
        }
        boolean f = false;
        if (check(a, b) && n[a][b] != -1) {
            n[a][b] = -1;
            f = true;
        }
        if (test(p1r, p1c) == false) {
            going = false;
        }
        return f;
    }

    /*
    * pre: game is going
    * post: move player's position
    * @param: player is player is a number representing player's turn
    * @param: direction is a number representing which position the player wants to move to
     */
    public boolean movePlayer(int player, int direction) {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                f[i][j] = true;
            }
        }
        int r1, c1, r2, c2, a, b;
        r1 = 0;
        c1 = 0;
        r2 = 0;
        c2 = 0;
        if (direction == 1) {
            c1 = 2;
            c2 = 1;
        } else if (direction == 2) {
            r1 = 2;
            r2 = 1;
        } else if (direction == 3) {
            c1 = -2;
            c2 = -1;
        } else if (direction == 4) {
            r1 = -2;
            r2 = -1;
        }
        boolean f = false;
        if (player == 1) {
            a = p1r + r1;
            b = p1c + c1;
            if (check(a, b) && n[p1r + r2][p1c + c2] != -1 && n[a][b] != 9) {
                n[p1r][p1c] = 0;
                p1r = a;
                p1c = b;
                n[p1r][p1c] = 9;
                f = true;
            }

        } else {
            a = p2r + r1;
            b = p2c + c1;
            if (check(a, b) && n[p2r + r2][p2c + c2] != -1 && n[a][b] != 9) {
                n[p2r][p2c] = 0;
                p2r = a;
                p2c = b;
                n[p2r][p2c] = 9;
                f = true;

            }
        }
        return f;
    }

    /*
    * pre: none
    * post: check if the position is within boundaries
    * @param: a is the row of the position
    * @param: b is the column of the next position
     */
    public boolean check(int a, int b) {
        boolean x = false;
        if (a < 13 && a > -1 && b < 13 && b > -1 && f[a][b]) {
            x = true;
        }
        return x;
    }

    /*
    pre: the game is going
    post: check if player one are seperated from player 2
    @param: r is the row of the current position being checked
    @param: c is the column of the current position being chekced
     */
    public boolean test(int r, int c) {
        f[r][c] = false;
        int r1, c1, r2, c2, a, b;
        boolean x = false;
        for (int i = 1; i <= 4; i++) {
            r1 = 0;
            c1 = 0;
            r2 = 0;
            c2 = 0;
            if (i == 1) {
                c1 = 2;
                c2 = 1;
            } else if (i == 2) {
                r1 = 2;
                r2 = 1;
            } else if (i == 3) {
                c1 = -2;
                c2 = -1;
            } else if (i == 4) {
                r1 = -2;
                r2 = -1;
            }
            if (check(r + r1, c + c1) && n[r + r2][c + c2] != -1) {
                if (n[r + r1][c + c1] == 9) {
                    x = true;
                } else if (test(r + r1, c + c1)) {
                    x = true;
                }
            }
        }
        return x;
    }

    /* 
    * pre: the game is finished and the two players are seperated
    * post: return the interval counts for a player
    * @param: r is the row of the current position being checked
    * @param: c is the column of the current position being chekced
     */
    public int count(int r, int c) {
        f[r][c] = false;
        int r1, c1, r2, c2, a, b;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= 4; i++) {
            r1 = 0;
            c1 = 0;
            r2 = 0;
            c2 = 0;
            if (i == 1) {
                c1 = 2;
                c2 = 1;
            } else if (i == 2) {
                r1 = 2;
                r2 = 1;
            } else if (i == 3) {
                c1 = -2;
                c2 = -1;
            } else if (i == 4) {
                r1 = -2;
                r2 = -1;
            }
            if (n[r + r2][c + c2] != -1 && f[r + r2][c + c2]) {
                y++;
                f[r + r2][c + c2] = false;
            }
            if (check(r + r1, c + c1) && n[r + r2][c + c2] != -1 && n[r + r1][c + c1] != 9) {
                x += count(r + r1, c + c1);
            }
        }
        return x + y;

    }

    /*
     * pre: none
     * post: return if the game is going
     */
    public boolean isGoing() {
        return going;
    }

    /*
    * pre: none
    * post: return the winner and interval counts for each player
     */
    public int[] winner() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                f[i][j] = true;
            }
        }
        int p1 = count(p1r, p1c);
        int p2 = count(p2r, p2c);
        int x = 0;
        if (p1 > p2) {
            x = 1;
        } else if (p2 > p1) {
            x = 2;
        } else {
            x = 3;
        }
        int[] s = new int[3];
        s[0] = x;
        s[1] = p1;
        s[2] = p2;
        return s;
    }

    /*
    pre: none
    post: output the board configuration of with text form for testing
     */
    public String println() {
        String s = "";
        String x = "";
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (n[i][j] == 1) {
                    x = "I";
                } else if (n[i][j] == -1) {
                    x = "X";
                } else if (n[i][j] == 9) {
                    x = "P";
                } else if (n[i][j] == 0 && i % 2 == 1 && j % 2 == 1) {
                    x = "O";
                } else if (n[i][j] == 0) {
                    x = "-";
                }
                s += x + " ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * pre: none post: return player 1's position
     */
    public String getP1() {
        return p1r + " " + p1c;
    }

    /**
     * pre: none post: return player 2's position
     */
    public String getP2() {
        return p2r + " " + p2c;
    }

    /*
    * pre: none
    * post: return the image icon for rules page
     */
    public ImageIcon getRules(int x) {
        ImageIcon i = null;
        if (x == 0) {
            if (rules > 1) {
                rules--;
            }
        } else {
            if (rules < 4) {
                rules++;
            }
        }
        String s = "/Image/Rule" + rules + ".png";
        i = new ImageIcon(getClass().getResource(s));
        return i;
    }

    /*
    pre: none
    post: return the image icon for board configuration
     */
    public ImageIcon getImage(int r, int c) {
        ImageIcon x = null;
        if ((n[r][c] == 9) && (p1r == r) && (p1c == c)) {
            x = new ImageIcon(getClass().getResource("/Image/Player1.png"));
        } else if ((n[r][c] == 9) && (p2r == r) && (p2c == c)) {
            x = new ImageIcon(getClass().getResource("/Image/Player2.png"));
        } else if ((n[r][c] == -1) && (r % 2 == 0)) {
            x = new ImageIcon(getClass().getResource("/Image/WallH.png"));
        } else if ((n[r][c] == -1) && (r % 2 == 1)) {
            x = new ImageIcon(getClass().getResource("/Image/WallV.png"));
        }
        return x;
    }
}
