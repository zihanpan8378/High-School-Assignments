/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOf21;

/**
 *
 * @author 44869
 */
public class GameOf21 {

    int tp, tc;
    int[] c;
    int[] cards;

    GameOf21() {
        tp = 0;
        tc = 0;
        c = new int[5];
        cards = new int[14];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = 4;
        }
    }

    //c[0], c[1] = computer's first & second cards; c[2], c[3], c[4] = player's first to third cards
    public void generat() {
        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random() * 13 + 1);
            while (cards[random] == 0) {
                random = (int) (Math.random() * 13 + 1);
            }
            c[i] = random;
            cards[random]--;
        }
    }
    
    public void thirdCard(boolean third) {
        if(third == true){
            int random = (int) (Math.random() * 13 + 1);
            while (cards[random] == 0) {
                random = (int) (Math.random() * 13 + 1);
            }
            c[4] = random;
            cards[random]--;
        } else {
            c[4] = 0;
        }
    }
    
    public String result() {
        tp = c[2]+c[3]+c[4];
        tc = c[0]+c[1];
        if(tp>21){
            if(tc>21){
                return "No winner";
            }
            else {return "Computer wins!";}
        } else if(tc>21) {
            return "Player wins!";
        } else
        if(tp>tc){
            return "Player wins!";
        } else if (tc>tp) {
            return "Computer wins!";
        } else {
            return "Same score";
        }
    }
}
