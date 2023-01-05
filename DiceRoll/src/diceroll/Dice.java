/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceroll;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author 44869
 */
public class Dice {
    
    Random r = new Random();
    int face;
    
    public int roll() {
        face = r.nextInt(6)+1;
        //System.out.println(face);
        return face;
    }
    
    public ImageIcon getImage(int num) {
        ImageIcon ic = null;
        String filename = "/diceroll/Images/" + num + ".png";
        ic = new ImageIcon(getClass().getResource(filename));
        /*if (num==1)
            ic = new ImageIcon(getClass().getResource("/diceroll/Images/1.png"));
        else if (num==2)
            ic = new ImageIcon(getClass().getResource("/diceroll/Images/2.png"));
        else if (num==3)
            ic = new ImageIcon(getClass().getResource("/diceroll/Images/3.png"));
        else if (num==4)
            ic = new ImageIcon(getClass().getResource("/diceroll/Images/4.png"));
        else if (num==5)
            ic = new ImageIcon(getClass().getResource("/diceroll/Images/5.png"));
        else 
            ic = new ImageIcon(getClass().getResource("/diceroll/Images/6.png"));*/
        return ic;
        
    }
    
}
