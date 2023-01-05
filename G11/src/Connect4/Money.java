/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect4;

/**
 *
 * @author 44869
 */
public class Money {

    int initial = 0;
    int risk, recent;
    Connect4 c = new Connect4();

    Money(int initial) {
        this.initial = initial;
        recent = initial;
    }

    public void takeRisk(int risk) {
        this.risk = risk;
        recent -= this.risk;
        c.set();
        c.print();
        System.out.println("number of connects: " + c.check());
    }

    public void newRecent() {
        if (c.check() > 0) {
            recent += (risk / 2) * c.check() + risk;
        } else {

        }
        System.out.println("corrent money in hand: " + recent);
    }
}
