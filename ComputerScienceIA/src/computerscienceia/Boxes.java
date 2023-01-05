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
public class Boxes {

    int player;
    boolean isOccupied = false;
    String boxName;
    int indexX, indexY, indexZ;

    public Boxes(int indexX, int indexY, int indexZ) {
        this.indexX = indexX;
        this.indexY = indexY;
        this.indexZ = indexZ;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

}
