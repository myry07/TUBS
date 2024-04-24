package chapter16.tankGame2;

import javax.swing.*;

/**
 * @author myry
 * @date 2024-11-27 15:11
 * JFrame 前端窗口
 */


public class Frame extends JFrame {

    MyPanel mp = null;//初始化 在构造器中new
    public static void main(String[] args) {
        Frame f = new Frame();
    }

    public Frame() {
        mp = new MyPanel();
        this.add(mp);//添加面板 游戏的绘图区域
        this.setSize(1000, 750);

        this.addKeyListener(mp);//增加监听事件 JFrame监听mp
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
