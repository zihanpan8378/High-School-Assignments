/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author 44869
 */
public class Dicegame {

    Random r = new Random();
    int face;

    public int roll() {
        face = r.nextInt(6) + 1;
        return face;
    }

    public ImageIcon getImage(int num) {
        ImageIcon ic = null;
        String filename = "/diceroll/Images/" + num + ".png";
        ic = new ImageIcon(getClass().getResource(filename));
        return ic;
    }

}
