/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        do{
            t.playerAction();
            t.check();
        }while(t.result == false);
        
    }

}
