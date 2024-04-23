package chapter18.TwoDGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener {
    Image cxkprofi = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame/cxkprofi.png"));
    User cxk = new User(150, 100, cxkprofi,"蔡徐坤", 26, "唱跳rap篮球");

    public MyPanel() throws IOException {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(150, 0, 700, 700);//填充矩形 默认黑色

        try {
            draw(g);
            drawUser1(g, cxk);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g) {
        g.drawString("名字: ", 0, 130);
        g.drawString("年龄: ", 0, 150);
        g.drawString("爱好: ", 0, 170);
    }

    public void drawUser1(Graphics g, User user) throws IOException {
        g.setColor(Color.BLACK);
        g.drawImage(user.getImage(), 0, 0, 100, 100, this);
        g.drawString(user.getName(), 50, 130);
        g.drawString("" + user.getAge(), 50, 150);
        g.drawString(user.getHobby(), 50, 170);

        Image imcxk = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame/cxk.png"));
        g.drawImage(imcxk, cxk.getX(), cxk.getY(), 100, 100, this);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wsad键
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//W 上
            //hero.setY(hero.getY() - 1);
            //太过繁琐 不如在父类中封装一个方法 供子类调用
            cxk.moveUp();
            cxk.setDirection(0);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//D 右
            cxk.moveRight();
            cxk.setDirection(1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//S 下
            cxk.moveDown();
            cxk.setDirection(2);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//A 左
            cxk.moveLeft();
            cxk.setDirection(3);
        }

        //重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
