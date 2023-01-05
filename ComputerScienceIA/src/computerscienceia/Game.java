/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceia;

/**
 *
 * @author 44869
 */
public class Game {

    Board b;
    Players nowPlayer, player1, player2;
    Players winner = null;

    /**
     * pre: none post: initialize the game
     *
     * @param b is the game board with a 3D array of Boxes
     * @param player1 is the first Players object
     * @param player2 is the second Players object
     */
    public Game(Board b, Players player1, Players player2) {
        this.player1 = player1;
        this.player2 = player2;
        nowPlayer = new Players(00, "");
        this.b = b;
        if ((int) (Math.random() * 2 + 1) == 1) {
            nowPlayer.setID(player1.getID());
            nowPlayer.setName(player1.getName());
        } else {
            nowPlayer.setID(player2.getID());
            nowPlayer.setName(player2.getName());
        }
    }

    /**
     * pre: none post: change the properties of the clicked cell, return whether
     * the cell is selected by a player
     *
     * @param box is the clicked cell
     * @return whether the characteristic of the box is changed by the clicking
     */
    public boolean click(Boxes box) {
        if (b.boxes[box.indexX][box.indexY][box.indexZ].isOccupied == true) {
            return false;
        } else {
            box.setPlayer(nowPlayer.getID());
            box.setIsOccupied(true);
            b.boxes[box.indexX][box.indexY][box.indexZ] = box;

            result(box);

            switchPlayer();
            return true;
        }
    }
    
    public void switchPlayer(){
        if (nowPlayer.getID() == player1.getID()) {
                nowPlayer.setID(player2.getID());
                nowPlayer.setName(player2.getName());
            } else {
                nowPlayer.setID(player1.getID());
                nowPlayer.setName(player1.getName());
            }
    }

    /**
     * pre: one unoccupied cell is clicked post: return whether there are three
     * cells occupied by the same player
     *
     * @param box is the clicked cell
     * @return whether the game is ended (a person connects a line on the cube)
     */
    public boolean endCheck(Boxes box) {
        Boxes near1, near2;
        for (int i = 0; i < b.boxes.length; i++) {
            for (int j = 0; j < b.boxes[0].length; j++) {
                for (int k = 0; k < b.boxes[0][0].length; k++) {
                    int x = 0, y = 0, z = 0;
                    boolean bx = false, by = false, bz = false;
                    if (Math.abs(i - box.indexX) == 1) {
                        x = i - box.indexX;
                        bx = true;
                    }
                    if (Math.abs(j - box.indexY) == 1) {
                        y = j - box.indexY;
                        by = true;
                    }
                    if (Math.abs(k - box.indexZ) == 1) {
                        z = k - box.indexZ;
                        bz = true;
                    }

                    if ((bx || by || bz)
                            && Math.abs(i - box.indexX) != 2
                            && Math.abs(j - box.indexY) != 2
                            && Math.abs(k - box.indexZ) != 2) {
                        near1 = b.boxes[i][j][k];

                        if (i + x < b.boxes.length && i + x >= 0
                                && j + y < b.boxes[0].length && j + y >= 0
                                && k + z < b.boxes[0][0].length && k + z >= 0) {
                            near2 = b.boxes[i + x][j + y][k + z];
                        } else {
                            near2 = null;
                        }
                    } else {
                        near1 = null;
                        near2 = null;
                    }

                    if (checkLine(box, near1, near2) == true) {
                        return true;
                    } else {
                        if (near1 != null && i - 2 * x < b.boxes.length && i - 2 * x >= 0
                                && j - 2 * y < b.boxes[0].length && j - 2 * y >= 0
                                && k - 2 * z < b.boxes[0][0].length && k - 2 * z >= 0) {
                            near2 = b.boxes[i - 2 * x][j - 2 * y][k - 2 * z];
                        } else {
                            near2 = null;
                        }
                        if (checkLine(box, near1, near2) == true) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * pre: one unoccupied cell is clicked; this method is called by endCheck();
     * post: return whether a single line is occupied by the same player
     *
     * @param box is the clicked cell,
     * @param near1 is the cell next to box, found by the endCheck() method
     * @param near2 is the cell next to near1 in the same direction, found by
     * the endCheck() method
     * @return whether the three cells are occupied by the same player
     */
    public boolean checkLine(Boxes box, Boxes near1, Boxes near2) {
        if (near1 != null && near2 != null) {
            if (near1.isOccupied == true && near2.isOccupied == true) {
                if (box.player == near1.player && box.player == near2.player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * pre: none post: return whether all the cells are occupied
     *
     * @return whether the board is filled without a winner
     */
    public boolean isFilled() {
        for (int i = 0; i < b.boxes.length; i++) {
            for (int j = 0; j < b.boxes[0].length; j++) {
                for (int k = 0; k < b.boxes[0][0].length; k++) {
                    if (b.boxes[i][j][k].isOccupied == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * pre: none post: return winner of the game
     *
     * @param box is the clicked cell
     * @return the winning Players object
     */
    public Players result(Boxes box) {
        if (endCheck(box) == true) {
            if (nowPlayer.getID() == player1.getID()) {
                setWinner(player1);
                return player1;
            } else if (nowPlayer.getID() == player2.getID()) {
                setWinner(player2);
                return player2;
            }
        } else {
            if (isFilled() == true) {
            }
        }
        return null;
    }

    public Board getB() {
        return b;
    }

    public void setB(Board b) {
        this.b = b;
    }

    public Players getNowPlayer() {
        return nowPlayer;
    }

    public void setNowPlayer(Players nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public Players getPlayer1() {
        return player1;
    }

    public void setPlayer1(Players player1) {
        this.player1 = player1;
    }

    public Players getPlayer2() {
        return player2;
    }

    public void setPlayer2(Players player2) {
        this.player2 = player2;
    }

    public Players getWinner() {
        return winner;
    }

    public void setWinner(Players winner) {
        this.winner = winner;
    }

}
