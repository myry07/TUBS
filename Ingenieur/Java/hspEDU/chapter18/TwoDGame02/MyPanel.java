package chapter18.TwoDGame02;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {
    MyUser cxk = null;
    EnemyUser mbg = null;
    Bomb bomb = null;

    Scanner scanner = new Scanner(System.in);

    public MyPanel() throws IOException {
        Image imgcxk = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/cxkprofi.png"));
        cxk = new MyUser(150, 0, "蔡徐坤", 30, 5, "唱跳rap篮球", imgcxk, 14);

        Image imgmbg = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/mbgprofi.png"));
        mbg = new EnemyUser(250, 350, "马保国", 90, 10, "功夫", imgmbg, 2);

        Thread thmbg = new Thread(mbg);
        thmbg.start();

        for (int i = 0; i < cxk.ikuns.size(); i++) {
            Shot shot = new Shot(cxk.ikuns.get(i).getX(), cxk.ikuns.get(i).getY(), cxk.ikuns.get(i).getDirection());
            cxk.ikuns.get(i).shots.add(shot);
            new Thread(shot).start();
        }


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(150, 0, 1000, 700);//填充矩形 默认黑色

        if (mbg.isLive() && cxk.isLive()) {
            try {
                draw(g);
                drawMyUser(g, cxk);
                drawMyShot(g, cxk);
                drawEnemyUser(g, mbg);
                drawEnemyShot(g, mbg);
                drawBomb(g, bomb);
                drawIkun(g, cxk);
                drawIkunShot(g, cxk);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            draw(g);
            try {
                drawMyUser(g, cxk);
                drawEnemyUser(g, mbg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (cxk.isLive()) {
                g.setColor(Color.cyan);
                g.drawString(cxk.getName() + "赢了", 300, 300);
            } else {
                g.setColor(Color.cyan);
                g.drawString(mbg.getName() + "赢了", 300, 300);
            }
        }
    }

    public void draw(Graphics g) {
        g.drawString("我方 ", 5, 20);
        g.drawString("名字 ", 5, 150);
        g.drawString("爱好 ", 5, 170);
        g.drawString("生命 ", 5, 190);

        g.drawString("敌方 ", 5, 350);
        g.drawString("名字 ", 5, 480);
        g.drawString("爱好 ", 5, 500);
        g.drawString("生命 ", 5, 520);
    }

    public void drawMyUser(Graphics g, MyUser myUser) throws IOException {
        g.setColor(Color.BLACK);
        g.drawImage(myUser.getImage(), 5, 30, 100, 100, this);
        g.drawString(myUser.getName(), 50, 150);
        g.drawString(myUser.getHobby(), 50, 170);

        if (myUser.isLive()) {
            Image imcxk = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/cxk.png"));
            g.drawImage(imcxk, cxk.getX(), cxk.getY(), 100, 100, this);
        }
        g.draw3DRect(50, 180, 90, 10, false);
        int hp = myUser.getHp();
        int len = 90 / 30 * hp;
        g.setColor(Color.RED);
        g.fillRect(50, 180, len, 10);
    }

    public void drawMyShot(Graphics g, MyUser myUser) throws IOException {
        g.setColor(Color.BLACK);
        for (int i = 0; i < myUser.shots.size(); i++) {
            Shot shot = myUser.shots.get(i);

            if (shot != null && shot.isLive()) {
                Image img = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/basketball.png"));
                g.drawImage(img, shot.getX(), shot.getY(), 30, 30, this);
            } else {
                myUser.shots.remove(shot);
            }
        }
    }

    public void drawEnemyUser(Graphics g, EnemyUser enemyUser) throws IOException {
        g.setColor(Color.BLACK);
        g.drawImage(enemyUser.getImage(), 5, 360, 100, 100, this);
        g.drawString(enemyUser.getName(), 50, 480);
        g.drawString(enemyUser.getHobby(), 50, 500);

        if (enemyUser.getHp() > 0) {
            Image img = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/mbg.png"));
            g.drawImage(img, enemyUser.getX(), enemyUser.getY(), 100, 100, this);
        }

        g.draw3DRect(50, 510, 90, 10, false);
        int hp = enemyUser.getHp();
        int len = 90 / 90 * hp;
        g.setColor(Color.RED);
        g.fillRect(50, 510, len, 10);
    }

    public void drawEnemyShot(Graphics g, EnemyUser enemyUser) {
        for (int i = 0; i < enemyUser.shots.size(); i++) {
            Shot shot = enemyUser.shots.get(i);

            if (shot != null && shot.isLive()) {
                g.setColor(Color.ORANGE);
                g.fill3DRect(shot.getX(), shot.getY(), 30, 30, false);
                g.draw3DRect(shot.getX(), shot.getY(), 30, 30, false);
            }
        }
    }

    public void drawBomb(Graphics g, Bomb bomb) throws IOException {
        Image image1 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/bomb1.png"));
        ;
        Image image2 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/bomb2.png"));
        ;
        Image image3 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/bomb3.png"));
        ;
        if (bomb != null && bomb.isLive) {
            if (bomb.getLife() > 2) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 100, 100, this);
            } else if (bomb.getLife() > 1) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 100, 100, this);
            } else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 100, 100, this);
            }
            //让炸弹生命减少 使得离散->连续
            bomb.lifeDown();
        }
    }

    public void drawIkun(Graphics g, MyUser myUser) {
        int ikunsize = myUser.ikuns.size();
        if (myUser.ikun01 != null && myUser.ikun01.isLive()) {
            for (int i = 0; i < ikunsize; i++) {
                g.drawImage(myUser.ikuns.get(i).getImage(),
                        myUser.ikuns.get(i).getX(),
                        myUser.ikuns.get(i).getY(),
                        50, 50, this);
            }
        }
    }

    public void drawIkunShot(Graphics g, MyUser myUser) {
        for (int i = 0; i < myUser.ikuns.size(); i++) {
            for (int j = 0; j < myUser.ikuns.get(i).shots.size(); j++) {
                Shot shot = myUser.ikuns.get(i).shots.get(j);

                if (shot != null && shot.isLive()) {
                    g.setColor(Color.ORANGE);
                    g.fill3DRect(shot.getX(), shot.getY(), 30, 30, false);
                    g.draw3DRect(shot.getX(), shot.getY(), 30, 30, false);
                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    //处理wsad键
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//W 上
            if (cxk.getY() > 0) {
                cxk.moveUp();
                cxk.setDirection(0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//D 右
            if (cxk.getX() + 100 < 1000) {
                cxk.moveRight();
                cxk.setDirection(1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//S 下
            if (cxk.getY() + 100 < 700) {
                cxk.moveDown();
                cxk.setDirection(2);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//A 左
            if (cxk.getX() > 150) {
                cxk.moveLeft();
                cxk.setDirection(3);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("篮球发射");
            cxk.attack();
        }

        if (e.getKeyCode() == KeyEvent.VK_K) {
            try {
                cxk.getHelp();
                System.out.println("召唤ikun");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        //重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        while (true) {//100ms重画
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < cxk.shots.size(); i++) {
                Shot shot = cxk.shots.get(i);
                if (shot != null && shot.isLive()) {
                    normalAttackHit(shot, mbg, cxk.getHit());
                }
            }

            if (cxk.ikuns.size() > 0) {
                IkunAttackBomb(cxk, mbg);
            }

            if (mbg.shot != null && mbg.shot.isLive()) {
                normalAttackHit(mbg.shot, cxk, mbg.getHit());
            }

            for (int i = 0; i < cxk.ikuns.size(); i++) {
                for (int j = 0; j < cxk.ikuns.get(i).shots.size(); j++) {
                        System.out.println("ikun发射");
                }
            }
            this.repaint();
        }
    }

    public void normalAttackHit(Shot shot, User user, int hit) {
        if (shot.getX() + 25 > user.getX() && shot.getX() < user.getX() + 100
                && shot.getY() + 25 > user.getY() && shot.getY() < user.getY() + 100) {
            shot.setLive(false);
            int hp = user.getHp();
            user.setHp(hp - hit);
            System.out.println("对" + user.getName() + " 造成了 " + hit);

            bomb = new Bomb(user.getX(), user.getY());

            if (user.getHp() <= 0) {
                bomb = new Bomb(user.getX(), user.getY());
                user.setLive(false);
            }
        }
    }

    public void IkunAttackBomb(MyUser myUser, EnemyUser enemyUser) {
        for (int i = 0; i < myUser.ikuns.size(); i++) {
            if (myUser.ikuns.get(i).getX() + 45 > enemyUser.getX() &&
                    myUser.ikuns.get(i).getX() < enemyUser.getX() + 100 &&
                    myUser.ikuns.get(i).getY() + 45 > enemyUser.getY() &&
                    myUser.ikuns.get(i).getY() < enemyUser.getY() + 100) {

                bomb = new Bomb(myUser.ikuns.get(i).getX(), myUser.ikuns.get(i).getY());
                myUser.ikuns.remove(i);
                int hp = enemyUser.getHp();
                enemyUser.setHp(hp - 7);

                if (enemyUser.getHp() <= 0) {
                    bomb = new Bomb(enemyUser.getX(), enemyUser.getY());
                }
            }
        }
    }
}
