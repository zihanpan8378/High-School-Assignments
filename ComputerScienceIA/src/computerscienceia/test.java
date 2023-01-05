/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceia;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {

        Game g = new Game(new Board(), new Players(01, "Tom"), new Players(02, "Jeck"));

        g.click(new Boxes(0, 0, 0));
        g.click(new Boxes(2, 1, 0));
        g.click(new Boxes(1, 0, 0));
        g.click(new Boxes(2, 2, 0));
        g.click(new Boxes(2, 0, 0));
        g.click(new Boxes(0, 0, 0));

    }

}
