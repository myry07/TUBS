package chapter16.jframe_;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MyPanel extends JPanel {
    User cxk = new User("蔡徐坤", 26, "唱跳rap篮球");

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(Color.black);
//        g.fillRect(0, 0, 500, 750);


        try {
            draw(g, cxk);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g, User user) throws IOException {
        g.setColor(Color.BLACK);
        g.drawString(user.getName(), 220, 20);
        g.drawString("" + user.getAge(), 220, 40);
        g.drawString(user.getHobby(), 220, 60);

        Image im = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter16/jframe_/cxk.png"));
        g.drawImage(im, 120, 300, 300, 300, this);

    }
}
