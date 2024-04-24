package chapter16.jframe_;

import javax.swing.*;

public class Frame extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        Frame f = new Frame();
    }

    public Frame() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(500, 750);
        this.setVisible(true);
    }
}
