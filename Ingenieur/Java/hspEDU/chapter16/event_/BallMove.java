package chapter16.event_;

import Dynamik.B;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyException;

/**
 * @author myry
 * @date 2024-36-27 15:36
 * 键盘控制小球移动
 * 通过该案列讲解java 事件处理机制
 */

public class BallMove extends JFrame {
    MyPanel mp = null;

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);//接口的引用 可以指向实现了该接口的对象
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        BallMove b = new BallMove();
    }

}

//监听Key 键盘
class MyPanel extends JPanel implements KeyListener {

    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //有字符输出
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + " 被按下");
        //e.getKeyCode() + " 被按下"
        //65 被按下
        //转成char

        //根据用户按下的不同按键 改变小球移动
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {//KeyEvent.VK_DOWN 就是向下的箭头对应的code
            y++;//向下为正
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }

        //wasd也可
        if(e.getKeyCode() == KeyEvent.VK_S) {//KeyEvent.VK_DOWN 就是向下的箭头对应的code
            y++;//向下为正
        } else if(e.getKeyCode() == KeyEvent.VK_W) {
            y--;
        } else if(e.getKeyCode() == KeyEvent.VK_A) {
            x--;
        } else if(e.getKeyCode() == KeyEvent.VK_D) {
            x++;
        }
        //让面板重绘制
        this.repaint();
    }

    //当某个键松开
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
