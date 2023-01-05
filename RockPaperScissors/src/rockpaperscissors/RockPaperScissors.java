/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author 44869
 */
public class RockPaperScissors {
    Random r = new Random();
    int image, CNum, PNum, Draws, GNum;
    
    public int roll() {
        image = r.nextInt(3)+1;
        //System.out.println(face);
        return image;
    }
    
    public ImageIcon getImage(int num) {
        ImageIcon ic = null;
        String filename = "/rockpaperscissors/images/" + image + ".png";
        ic = new ImageIcon(getClass().getResource(filename));
        return ic;
    }
}
