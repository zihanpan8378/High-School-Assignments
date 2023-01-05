/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MouseClick;

/**
 *
 * @author 44869
 */
public class NumClicks {
    int numClick;
    
    public void countClick() {
        numClick++;
    }
    
    public String toString() {
        return "You clicked: " + numClick + " times";
    }
}
