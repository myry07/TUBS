package chapter18.TwoDGame02;

import javax.swing.*;
import java.io.IOException;

@SuppressWarnings({"all"})
public class Game extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) throws IOException {
        Game f = new Game();
    }

    public Game() throws IOException {
        mp = new MyPanel();
        //将mp放入Thread 并启动
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);
        this.setSize(1000, 700);
        this.setVisible(true);

        this.addKeyListener(mp);//增加监听事件 JFrame监听mp
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
