package Game;

import static Game.MyPanelq.obstacle;
import static Game.MyPanelq.obstacleDynamic;
import static Game.MyPanelq.wall;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Client extends JFrame {

    int port;
    String ip;

    public void ServerIni() {
        try {
            Socket socket = new Socket(ip, port);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                        while (true) {

                            String data = "";
                            data = mp.x2 + " " + mp.y2 + " " + mp.dr2 + " ";
                            // System.out.println("before: "+mp.bulletsDynamic.size());
                            String data2 = data;
                            for (int i = 0; i < mp.bulletsDynamic.size(); i++) {

                                data = data + mp.bulletsDynamic.get(i).x + " " + mp.bulletsDynamic.get(i).y + " " + mp.bulletsDynamic.get(i).dir + " ";
                                mp.bulletsDynamic.remove(i);
                            }

                            for (int i = 0; i < obstacleDynamic.size(); i++) {
                                data = data+ obstacleDynamic.get(i).x + " " + obstacleDynamic.get(i).y + " " + obstacleDynamic.get(i).dir + " ";
                                obstacleDynamic.remove(i);
                            }
                            
                            data += "\n";
                            
                            bufferedWriter.write(data);
                            /*try {
                                Thread.sleep(300);
                                //System.out.println(mp.x2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }*/

                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /* try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
            }).start();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        String read;
                        while ((read = bufferedReader.readLine()) != null) {
                            int check = 0;

                            for (int i = 0; i < read.length(); i++) {
                                if (read.substring(i, i + 1).equals(" ") && check == 0) {
                                    mp.x = Integer.parseInt(read.substring(0, i));
                                    read = read.substring(i + 1, read.length());
                                    i = 0;
                                    check++;
                                } else if (read.substring(i, i + 1).equals(" ") && check == 1) {
                                    mp.y = Integer.parseInt(read.substring(0, i));
                                    read = read.substring(i + 1, read.length());
                                    i = 0;
                                    check++;
                                } else if (read.substring(i, i + 1).equals(" ") && check == 2) {
                                    mp.dr = Integer.parseInt(read.substring(0, i));
                                    read = read.substring(i + 1, read.length());
                                    check++;

                                } else if (read.substring(i, i + 1).equals(" ") && check == 3) {
                                    System.out.println("bullet!");
                                    

                                    int x = 0;
                                    int y = 0;
                                    int dr = 0;
                                    int c = 0;

                                    while (c < 3) {
                                        //System.out.println("daole 2");
                                        for (int k = 0; k < read.length(); k++) {
                                            // System.out.println(read);
                                            if (read.substring(k, k + 1).equals(" ") && c == 0) {
                                                x = Integer.parseInt(read.substring(0, k));
                                                read = read.substring(k + 1, read.length());
                                                k = 0;
                                                c++;
                                                //System.out.println("daole 3");
                                            } else if (read.substring(k, k + 1).equals(" ") && c == 1) {
                                                y = Integer.parseInt(read.substring(0, k));
                                                read = read.substring(k + 1, read.length());
                                                k = 0;
                                                c++;
                                                //System.out.println("daole 4");
                                            } else if (read.substring(k, k + 1).equals(" ") && c == 2) {
                                                dr = Integer.parseInt(read.substring(0, k));

                                                read = read.substring(k + 1, read.length());
                                                //System.out.println("daole 5");
                                                c++;
                                                break;
                                            }
                                        }

                                        if (dr != 0) {
                                            if (dr == 5 || dr == 6) {
                                                Image a = new ImageIcon(getClass().getResource("texture" + dr + ".jpeg")).getImage();
                                                mp.wall.add(a);
                                                mp.t = mp.new Wall();
                                                mp.t.setAll(x, y, dr);
                                                obstacle.add(mp.t);
                                            } else {
                                                mp.e = mp.new Bullet();
                                                mp.e.setAll(x, y, dr);

                                                mp.i = new ImageIcon(getClass().getResource("bullet" + dr + ".png")).getImage();
                                                mp.fireball2.add(mp.i);
                                                mp.bullets2.add(mp.e);
                                            }
                                        }

                                    }

                                } /*else if (read.substring(i, i + 1).equals(" ") && check == 3) {

                                    System.out.println("yes");
                                    int x = 0;
                                    int y = 0;
                                    int dr = 0;
                                    int c = 0;

                                    while (c < 3) {
                                        //System.out.println("daole 2");
                                        for (int k = 0; k < read.length(); k++) {
                                            // System.out.println(read);
                                            if (read.substring(k, k + 1).equals(" ") && c == 0) {
                                                x = Integer.parseInt(read.substring(0, k));
                                                read = read.substring(k + 1, read.length());
                                                k = 0;
                                                c++;
                                                //System.out.println("daole 3");
                                            } else if (read.substring(k, k + 1).equals(" ") && c == 1) {
                                                y = Integer.parseInt(read.substring(0, k));
                                                read = read.substring(k + 1, read.length());
                                                k = 0;
                                                c++;
                                                //System.out.println("daole 4");
                                            } else if (read.substring(k, k + 1).equals(" ") && c == 2) {
                                                dr = Integer.parseInt(read.substring(0, k));
                                                read = read.substring(k + 1, read.length());
                                                //System.out.println("daole 5");
                                                c++;
                                                break;
                                            }
                                            System.out.println("reach!");
                                            if (dr != 0) {
                                                Image a = new ImageIcon(getClass().getResource("texture" + dr + ".jpeg")).getImage();
                                                mp.wall.add(a);
                                                mp.t = mp.new Wall();
                                                mp.t.setAll(x, y, dr);
                                                obstacle.add(mp.t);
                                            }
                                        }

                                    }

                                }*/
                                /*try {
                                    Thread.sleep(300);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                                }*/

                            }
                            //System.out.println(mp.x + " " + mp.y+" "+mp.dr);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /* try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
            }).
                    start();

            /* new Thread(new Runnable() {
                @Override
                public void run() {
                    
                }
            }).start();*/
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    MyPanelq mp = null;

    public static void main(String[] args) throws IOException, SQLException {
        Client ss = new Client("192.168.100.3", 8888, "user1");
    }

    public Client(String ip, int port, String name) throws IOException, SQLException {

        this.ip = ip;
        this.port = port;
        mp = new MyPanelq();
        add(mp);
        addKeyListener(mp);

        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 400) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2, 500, 500);
        setDefaultCloseOperation(3);
        setVisible(true);
        ServerIni();
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean con = true;
                while (con) {
                    int check = mp.getWinner();
                    //  System.out.println("this: " + check);
                    if (check == 1) {
                        try {
                            System.out.println("win");

                            WiningPage a = new WiningPage(1, ip, port, name);
                            a.setVisible(true);

                            con = false;
                            dispose();

                        } catch (SQLException ex) {
                            Logger.getLogger(Client.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (check == 2) {
                        try {
                            System.out.println("lose");

                            LosingPage a = new LosingPage(1, ip, port, name);
                            a.setVisible(true);

                            con = false;
                            dispose();

                        } catch (SQLException ex) {
                            Logger.getLogger(Client.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        }).start();

    }
}

class MyPanelq extends JPanel implements KeyListener {

    int limit = 5;
    int winner;
    boolean w, a, s, d, space;
    Bullet e;
    Wall t;
    Image i;
    int p1h = 100, p2h = 100;
    static ArrayList<Bullet> bullets = new ArrayList();
    static ArrayList<Image> fireball = new ArrayList();
    static ArrayList<Enemy> enemies = new ArrayList();
    static ArrayList<Image> monster = new ArrayList();

    static ArrayList<Bullet> bullets2 = new ArrayList();
    static ArrayList<Image> fireball2 = new ArrayList();

    static ArrayList<Wall> obstacle = new ArrayList();
    static ArrayList<Image> wall = new ArrayList();

    static ArrayList<Wall> obstacleDynamic = new ArrayList();

    Vector drawer = new Vector();
    int dr = 1, dr2 = 1;
    int x = 100, y = 100;
    int x2 = 200, y2 = 200;
    allTimer al = new allTimer();
    //BufferedImage bi;
    Image chara = new ImageIcon(getClass().getResource("png" + 1 + ".png")).getImage();
    Image chara2 = new ImageIcon(getClass().getResource("png" + 1 + ".png")).getImage();
    Graphics g;
    static ArrayList<Bullet> bulletsDynamic = new ArrayList();

    public MyPanelq() throws IOException {
        winner = 0;
        //String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        //path += "picture.png";
        /*this.bi = ImageIO.read(new File(path));
        for (int i = 0; i < 4; i++) {
            BufferedImage biNew = bi.getSubimage(32 * (i % 3), 32 * (i / 3), 32, 32);
            ImageIO.write(biNew, "png", new File(i + ".png"));
        }*/
        //al.timer.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void setWinner(boolean h) {
        if (h) {
            winner = 1;
            //System.out.println("check1: " + getWinner());

        } else {
            winner = 2;
            //System.out.println("check2: " + getWinner());
        }
        System.out.println(winner);
    }

    public int getWinner() {
        return winner;
    }

    public void paint(Graphics g) {

        this.g = g;
        if (p2h > 0 && p1h > 0) {
            move();
        }
        if (p2h > 0) {
            chara = new ImageIcon(getClass().getResource("png" + dr + ".png")).getImage();
            g.drawImage(chara, x, y, 50, 50, null);
            g.setColor(Color.black);
            g.drawRect(x - 20, y - 30, 100, 20);
            g.setColor(Color.red);
            g.drawRect(x - 20, y - 30, p2h, 20);
        } else {
            //System.out.println("set win");
            setWinner(true);
        }

        if (p1h > 0) {
            chara2 = new ImageIcon(getClass().getResource("png" + dr2 + ".png")).getImage();
            g.setColor(Color.black);
            g.drawImage(chara2, x2, y2, 50, 50, null);
            g.drawRect(x2 - 20, y2 - 30, 100, 20);
            g.setColor(Color.blue);
            g.drawRect(x2 - 20, y2 - 30, p1h, 20);
        } else {
            //System.out.println("set lose");
            setWinner(false);
        }

        //System.out.println(x + " " + y);
        for (int i = 0; i < bullets.size(); i++) {
            moveBullet(i);
            if (!removeChecker(bullets.get(i).x, bullets.get(i).y)) {
                bullets.get(i).timer.stop();
                bullets.remove(i);
                fireball.remove(i);
            } else {
                if ((bullets.get(i).x > x - 5 && bullets.get(i).x < x + 50) && (bullets.get(i).y > y - 5 && bullets.get(i).y < y + 50)) {
                    bullets.remove(i);
                    fireball.remove(i);
                    p2h -= 4;
                } else {
                    g.drawImage(fireball.get(i), bullets.get(i).x, bullets.get(i).y, 20, 20, null);
                }

            }
        }

        for (int i = 0; i < bullets2.size(); i++) {
            moveBullet2(i);
            if (!removeChecker(bullets2.get(i).x, bullets2.get(i).y)) {
                bullets2.get(i).timer.stop();
                bullets2.remove(i);
                fireball2.remove(i);
            } else {
                if ((bullets2.get(i).x > x2 - 5 && bullets2.get(i).x < x2 + 50) && (bullets2.get(i).y > y2 - 5 && bullets2.get(i).y < y2 + 50)) {
                    bullets2.remove(i);
                    fireball2.remove(i);
                    p1h -= 4;
                } else {
                    g.drawImage(fireball2.get(i), bullets2.get(i).x, bullets2.get(i).y, 20, 20, null);
                }
            }
        }

        for (int i = 0; i < obstacle.size(); i++) {
            g.drawImage(wall.get(i), obstacle.get(i).x, obstacle.get(i).y, 35, 35, null);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_F) {
            //System.out.println("F");
            a = true;
            dr2 = 1;

        }
        if (e.getKeyCode() == KeyEvent.VK_H) {
            //System.out.println("H");
            d = true;
            dr2 = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_T) {
            //System.out.println("T");
            w = true;
            dr2 = 3;
        }
        if (e.getKeyCode() == KeyEvent.VK_G) {
            //System.out.println("G");
            s = true;
            dr2 = 4;
        }
        /* if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Image f = new ImageIcon(getClass().getResource("bullet" + dr2 + ".png")).getImage();
            Bullet b = new Bullet();
            b.setPosi(fireball.size());
            fireball.add(f);
            b.setAll(x2 + 40, y2 + 50, dr2);
            bullets.add(b);
            bulletsDynamic.add(b);
        }*/
 /*
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                a = true;
                dr2 = 1;
                break;
            case KeyEvent.VK_D:
                d = true;
                dr2 = 2;
                break;
            case KeyEvent.VK_W:
                w = true;
                dr2 = 3;
                break;
            case KeyEvent.VK_S:
                s = true;
                dr2 = 4;
                break;

        }*/
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F) {

            a = false;
            //requestFocus();
        }
        if (e.getKeyCode() == KeyEvent.VK_H) {

            d = false;
            //requestFocus();
        }
        if (e.getKeyCode() == KeyEvent.VK_G) {

            s = false;
            //requestFocus();
        }
        if (e.getKeyCode() == KeyEvent.VK_T) {

            w = false;
            //requestFocus();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Image f = new ImageIcon(getClass().getResource("bullet" + dr2 + ".png")).getImage();
            Bullet b = new Bullet();
            b.setPosi(fireball.size());
            fireball.add(f);
            b.setAll(x2 + 15, y2 + 15, dr2);
            bullets.add(b);
            bulletsDynamic.add(b);
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            Image f = null;
            int ddir = 0;
            if (limit > 0) {
                if (dr2 == 3 || dr2 == 4) {
                    f = new ImageIcon(getClass().getResource("texture" + 6 + ".jpeg")).getImage();
                    ddir = 6;
                } else if (dr2 == 1 || dr2 == 2) {
                    f = new ImageIcon(getClass().getResource("texture" + 5 + ".jpeg")).getImage();
                    ddir = 5;
                }

                Wall temp = new Wall();
                temp.setAll(x2, y2, ddir);
                wall.add(f);
                obstacle.add(temp);
                obstacleDynamic.add(temp);

            }
        }
        /*switch (e.getKeyCode()) {
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
                Image f = new ImageIcon(getClass().getResource("bullet" + dr2 + ".png")).getImage();
                Bullet b = new Bullet();
                b.setPosi(fireball.size());
                fireball.add(f);
                b.setAll(x + 40, y + 50, dr);
                bullets.add(b);
                break;
        }*/
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /*public void drawCharater(Graphics g){
        move();
        chara = new ImageIcon(getClass().getResource("png" + dr + ".png")).getImage();
         g.drawImage(chara, x, y, 100, 100, null);
    }*/
    public void move() {
        if (a) {
            x2 -= 2;
        } else if (d) {
            x2 += 2;
        } else if (w) {
            y2 -= 2;
        } else if (s) {
            y2 += 2;
        }

        if (x > 430) {
            x2 -= 10;
        } else if (x < -10) {
            x2 += 10;
        }
        if (y < -10) {
            y2 += 10;
        } else if (y > 400) {
            y2 -= 10;
        }
    }

    public boolean removeChecker(int x, int y) {
        if ((x > -10 && x < 500) && (y > -10 && y < 500)) {
            if (touchWall(x, y)) {
                return false;
            } else if (!touchWall(x, y)) {
                return true;
            }

        }
        return false;
    }

    public boolean touchWall(int x, int y) {
        for (int j = 0; j < obstacle.size(); j++) {
            if ((x > obstacle.get(j).x - 10 && x < obstacle.get(j).x + 35) && (y > obstacle.get(j).y - 10 && y < obstacle.get(j).y + 35)) {
                return true;
            }
        }
        return false;
    }

    public void moveBullet(int i) {

        if (bullets.get(i).dir == 1) {
            bullets.get(i).x -= 5;
            //System.out.println("1");
        }
        if (bullets.get(i).dir == 2) {
            bullets.get(i).x += 5;
            //System.out.println("2");
        }
        if (bullets.get(i).dir == 3) {
            bullets.get(i).y -= 5;
            // System.out.println("3");
        }
        if (bullets.get(i).dir == 4) {
            bullets.get(i).y += 5;
            // System.out.println("4");
        }
        //System.out.println(bullets.get(i).x + "x,y" + bullets.get(i).y);

    }

    public void moveBullet2(int i) {

        if (bullets2.get(i).dir == 1) {
            bullets2.get(i).x -= 5;
            //System.out.println("1");
        }
        if (bullets2.get(i).dir == 2) {
            bullets2.get(i).x += 5;
            // System.out.println("2");
        }
        if (bullets2.get(i).dir == 3) {
            bullets2.get(i).y -= 5;
            //System.out.println("3");
        }
        if (bullets2.get(i).dir == 4) {
            bullets2.get(i).y += 5;
            //System.out.println("4");
        }
        // System.out.println(bullets2.get(i).x + "x,y" + bullets2.get(i).y);

    }

    class Bullet {

        int x, y, dir, i;
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

    /*public void moveEnemy(int i){
        
    }
    public int dependsDirection(int dir, int x){
        
    }*/
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

    class Wall {

        int x, y, dir;

        public void setAll(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
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

        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }

        });
    }
}
