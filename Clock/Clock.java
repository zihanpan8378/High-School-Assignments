/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;

/**
 *
 * @author 44869
 */
public class Clock {

    int hours;
    int mins;

    public Clock(int h, int m) {
        hours = h;
        mins = m;
    }

    public int getHours() {
        return hours;
    }

    public int getMins() {
        return mins;
    }

    public void advance() {
        mins++;
        if (mins >= 60) {
            mins = 0;
            hours++;
        }

        if (hours >= 12) {
            hours = 0;
        }
    }

    @Override
    public String toString() {
        return hours + ":" + mins;
    }
    
    

}
