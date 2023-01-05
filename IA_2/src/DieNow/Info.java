/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DieNow;

/**
 *
 * @author 40474
 */
public class Info {

    private String name;
    private int wins, loses;
    private double winrate;

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public double getWinrate() {
        return winrate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public void setWinrate(double winrate) {
        this.winrate = Double.parseDouble(String.format("%.1f", winrate));
    }

    @Override
    public String toString() {
        return (name + ";" + wins + ";" + loses + ";" + winrate);
    }
}
