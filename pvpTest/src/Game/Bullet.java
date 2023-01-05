package Game;



import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44485
 */
    public class Bullet {

        int x, y, dir, i;
        private boolean isAlive;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDr() {
            return dir;
        }

        public void setAll(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            isAlive = true;
        }

        public boolean getAlive() {
            return isAlive;
        }

        public void setPosi(int i) {
            this.i = i;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void move() {
            if (dir == 1) {
                x -= 3;
            } else if (dir == 2) {
                x += 3;
            } else if (dir == 3) {
                y -= 3;
            } else if (dir == 4) {
                y += 3;
            }
        }

    }