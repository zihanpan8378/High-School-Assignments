/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 *
 * @author 44869
 */
public class Bet {

    int bet = 0, finalMoney = 10000, gameMoney, n1, n2, n3;
    String result;

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getBet() {
        //finalMoney += bet;
        return bet;
    }

    public int getGameMoney() {
        gameMoney = 0;
        if (n1 == n2 && n2 == n3 && n1 == 1) {
            gameMoney = 2 * bet;
        } else if (n1 == n2 && n2 == n3) {
            gameMoney = 1 * bet;
        } else {
            gameMoney = 0 - bet;
        }
        return gameMoney;
    }

    public int getFinalMoney() {
        finalMoney = finalMoney+gameMoney;
        //finalMoney += gameMoney;
        return finalMoney;
    }

    public String getResult() {
        if (finalMoney <= 0) {
            result = "You lose the game because you don't have money.";
        } else {
            result = "You betted " + bet + " and you get " + (gameMoney + bet);
        }
        return result;
    }
    public void setResult() {
        result = null;
    }
}
