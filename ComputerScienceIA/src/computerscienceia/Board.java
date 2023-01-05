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
public class Board {
    Boxes[][][] boxes;
    String[][][] target;
    
    /**
     * pre: none
     * post: initialize the board, 
     */
    public Board(){ 
        target = new String[3][3][3];
        boxes = new Boxes[3][3][3];
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[0].length; j++) {
                for (int k = 0; k < boxes[0][0].length; k++) {
                    boxes[i][j][k] = new Boxes(i, j, k);
                    boxes[i][j][k].setIsOccupied(false);
                    boxes[i][j][k].setPlayer(0);
                    boxes[i][j][k].setBoxName(target[i][j][k]);
                }
            }
        }
    }

    public Boxes[][][] getBoxes() {
        return boxes;
    }

    public void setBoxes(Boxes[][][] boxes) {
        this.boxes = boxes;
    }

    public String[][][] getTarget() {
        return target;
    }

    public void setTarget(String[][][] target) {
        this.target = target;
    }
    
    
}
