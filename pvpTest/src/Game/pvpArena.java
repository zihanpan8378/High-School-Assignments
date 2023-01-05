package Game;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class pvpArena extends JFrame {

    MyPaneld mp = null;

    public static void main(String[] args) throws IOException {
        pvpArena ss = new pvpArena();
    }

    public pvpArena() throws IOException {
        mp = new MyPaneld();
        add(mp);
        addKeyListener(mp);

        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 400) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2, 500, 500);
        setDefaultCloseOperation(3);
        setVisible(true);

    }
}

class MyPaneld extends JPanel implements KeyListener {

    boolean w, a, s, d, space;
    
    static ArrayList<Bullet> bullets = new ArrayList();
    static ArrayList<Image> fireball = new ArrayList();
    static ArrayList<Enemy> enemies = new ArrayList();
    static ArrayList<Image> monster = new ArrayList();
    Vector drawer = new Vector();
    int dr = 1;
    int x = 100, y = 100;
    allTimer al = new allTimer();
    //BufferedImage bi;
    Image chara = new ImageIcon(getClass().getResource("png" + 1 + ".png")).getImage();
    Graphics g;

    public MyPaneld() throws IOException {

        al.timer.start();
    }

    public void paint(Graphics g) {
        move();
        this.g = g;
        chara = new ImageIcon(getClass().getResource("png" + dr + ".png")).getImage();
        g.drawImage(chara, x, y, 100, 100, null);
        System.out.println(x + " " + y);
        for (int i = 0; i < bullets.size(); i++) {
            moveBullet(i);
            if (!removeChecker(bullets.get(i).x, bullets.get(i).y)) {
                bullets.get(i).timer.stop();
                bullets.remove(i);
                fireball.remove(i);
            } else {
                g.drawImage(fireball.get(i), bullets.get(i).x, bullets.get(i).y, 20, 20, null);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                a = true;
                dr = 1;
                break;
            case KeyEvent.VK_D:
                d = true;
                dr = 2;
                break;
            case KeyEvent.VK_W:
                w = true;
                dr = 3;
                break;
            case KeyEvent.VK_S:
                s = true;
                dr = 4;
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                a = false;
                break;
            case KeyEvent.VK_D:
                d = false;
                break;
            case KeyEvent.VK_W:
                w = false;
                break;
            case KeyEvent.VK_S:
                s = false;
                break;
            case KeyEvent.VK_SPACE:
                Image f = new ImageIcon(getClass().getResource("bullet" + dr + ".png")).getImage();
                Bullet b = new Bullet();
                b.setPosi(fireball.size());
                fireball.add(f);
                b.setAll(x + 40, y + 50, dr);
                bullets.add(b);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void move() {
        if (a) {
            x -= 2;
        } else if (d) {
            x += 2;
        } else if (w) {
            y -= 2;
        } else if (s) {
            y += 2;
        }

        if (x > 430) {
            x -= 10;
        } else if (x < -10) {
            x += 10;
        }
        if (y < -10) {
            y += 10;
        } else if (y > 400) {
            y -= 10;
        }
    }

    public boolean removeChecker(int x, int y) {
        if ((x > -10 && x < 500) && (y > -10 && y < 500)) {
            return true;
        } else {
            return false;
        }
    }

    public void moveBullet(int i) {

        if (bullets.get(i).dir == 1) {
            bullets.get(i).x -= 5;
            System.out.println("1");
        }
        if (bullets.get(i).dir == 2) {
            bullets.get(i).x += 5;
            System.out.println("2");
        }
        if (bullets.get(i).dir == 3) {
            bullets.get(i).y -= 5;
            System.out.println("3");
        }
        if (bullets.get(i).dir == 4) {
            bullets.get(i).y += 5;
            System.out.println("4");
        }
        System.out.println(bullets.get(i).x + "x,y" + bullets.get(i).y);

    }

    class Bullet {

        private int x, y, dir, i;
        private boolean isAlive;

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

       public void drawBullet(Graphics g) {
            g.drawImage(fireball.get(i), x, y, 20, 20, null);
        }
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                move();
                System.out.println("bullet:" + x + " " + y);
                drawBullet(g);
            }
        });
    }

    public void enemyDrawer(Graphics g) {
        for (int i = 0; i < bullets.size(); i++) {
            boolean t = removeChecker(bullets.get(i).x, bullets.get(i).y);
            moveBullet(i);
            if (!t) {
                bullets.remove(i);
                fireball.remove(i);
            } else {
                g.drawImage(fireball.get(i), bullets.get(i).x, bullets.get(i).y, 20, 20, null);
            }
        }
    }


    public int getRandomX(int dir) {
        if (dir == 1 || dir == 3) {
            return (int) (Math.random() * 500);
        } else if (dir == 2 || dir == 4) {
            return (int) (Math.random() * 500);
        } else {
            return 0;
        }
    }

    public int getRandomY(int dir) {
        if (dir == 1 || dir == 3) {
            return (int) (Math.random() * 500);
        } else if (dir == 2 || dir == 4) {
            return (int) (Math.random() * 500);
        } else {
            return 0;
        }
    }

    class Enemy {

        int x, y, dir;
        boolean isAlive;

        public void setAll(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void setIsAlive(boolean isAlive) {
            this.isAlive = isAlive;
        }
    }

    class enemySpawner {

        int time = 0;
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time++;
                if (time == 5) {
                    time = 0;
                    Enemy en = new Enemy();
                    int dir = (int) (Math.random() * 4) + 1;
                    en.setAll(getRandomX(dir), getRandomY(dir), dir);
                    Image enemy = new ImageIcon(getClass().getResource("enemy" + dir + ".png")).getImage();
                    monster.add(enemy);

                }
            }
        });
    }

    class enemyTimer {

    }

    class allTimer {

        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                repaint();
                
            }

        });
    }
}
