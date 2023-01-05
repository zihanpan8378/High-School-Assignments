/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdowntimer;

/**
 *
 * @author 44869
 */
public class CountDown {

    int count = 10;
    String cdText;

    public void beginCountDown() {
        cdText = String.valueOf(count);
        if (count > 0) {
            count--;
        } else {
            cdText = "Time is up";
        }
    }

    public int getCount() {
        return count;
    }

    public String getCdText() {
        return cdText;
    }

}
