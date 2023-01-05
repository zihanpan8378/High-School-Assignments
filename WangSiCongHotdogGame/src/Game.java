
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
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
public class Game extends JFrame {

    MyPanel mp;

    public static void main(String[] args) throws IOException {
        Game g = new Game();
    }

    public Game() throws IOException {
        mp = new MyPanel();
        add(mp);
        addKeyListener(mp);

        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 400) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2, 500, 500);
        setDefaultCloseOperation(3);
        setVisible(true);

    }
}

class MyPanel extends JPanel implements KeyListener {

    boolean a, d;
    static ArrayList<Bread> entities = new ArrayList();
    static ArrayList<Image> breads = new ArrayList();
    int x = 200, y = 380;
    allTimer al = new allTimer();
    //BufferedImage bi;
    Image chara = new ImageIcon(getClass().getResource("Charater.png")).getImage();
    Graphics g;

    public MyPanel() throws IOException {
        al.timer.start();

    }

    public void paint(Graphics g) {
        move();
        g.drawImage(chara, x, y, 100, 100, null);
        for (int i = 0; i < entities.size(); i++) {
            moveBread(i);
            g.drawImage(breads.get(i), entities.get(i).getX(), entities.get(i).getY(), this);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F:
                a = true;
                break;
            case KeyEvent.VK_J:
                d = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F:
                a = false;
                break;
            case KeyEvent.VK_J:
                d = false;
                break;
        }
    }

    public boolean removeChecker(int x, int y, int i) {
        if ((x > -10 && x < 500) && (y > -10 && y < 500)) {
            return true;
        } else {
            return false;
        }
    }

    public void move() {
        if (x > 430) {
            if (a) {
                x -= 10;
            }
        }
        if (x < -10) {
            if (d) {
                x += 10;
            }
        } else {
            if (a) {
                x -= 10;
            }
            if (d) {
                x += 10;
            }
        }
        /* if (x > 430) {
            x -= 10;
        } else if (x < -10) {
            x += 10;
        }
        if (y < -10) {
            y += 10;
        } else if (y > 400) {
            y -= 10;
        }*/

    }

    public void moveBread(int i) {
        if (entities.get(i).getY() < 500) {
            entities.get(i).setY(entities.get(i).getY() + 4);
        } else {
            entities.remove(i);
            breads.remove(i);
        }
        if ((entities.get(i).getX() > (x + 10) && entities.get(i).getX() < (x + 70)) && (entities.get(i).getY() > (y - 30))) {
            entities.remove(i);
            breads.remove(i);
        }
    }

    class Bread {

        int x, y;

        public Bread() {
            x = ((int) (Math.random() * 450.0D + 10.0D));
            y = 0;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

    }

    class allTimer {

        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
                entities.add(new Bread());
                breads.add(new ImageIcon(getClass().getResource("Bread.png")).getImage());
            }

        });
    }

}
