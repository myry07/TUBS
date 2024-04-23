package chapter18.TwoDGame02;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

@SuppressWarnings({"all"})
public class MyUser extends User {
    Shot shot = null;
    Ikun ikun01 = null;
    Ikun ikun02 = null;
    Ikun ikun03 = null;
    Ikun ikun04 = null;
    Ikun ikun05 = null;
    Ikun ikun06 = null;
    Ikun ikun07 = null;
    int ikunsize = 7;
    Vector<Ikun> ikuns = new Vector<>();
    Vector<Shot> shots = new Vector<>();

    public MyUser(int x, int y, String name, int hp, int hit, String hobby, Image image, int speed) {
        super(x, y, name, hp, hit, hobby, image, speed);
    }

    public void attack() {
        if(shots.size() == 7) {//最多子弹树木
            return;
        }

        switch (getDirection()) {
            case 0://向上
                shot = new Shot(getX() + 35, getY() - 30, 0);
                break;
            case 1://向右
                shot = new Shot(getX() + 100, getY() + 50, 1);
                break;
            case 2://向下
                shot = new Shot(getX() + 30, getY() + 100, 2);
                break;
            case 3://向左
                shot = new Shot(getX() - 25, getY() + 50, 3);
                break;
        }
        shots.add(shot);
        Thread t = new Thread(shot);
        t.start();//启动线程
    }

    @Test
    public void getHelp() throws IOException {
        Image image01 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/ikun01.png"));
        Image image02 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/ikun02.png"));
        Image image03 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/ikun03.png"));
        Image image04 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/ikun04.png"));
        Image image05 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/ikun05.png"));
        Image image06 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/ikun06.png"));
        Image image07 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/TwoDGame02/pngs/ikun07.png"));

        ikun01 = new Ikun(getX() - 70, getY() - 70, image01);
        ikun02 = new Ikun(getX() + 70, getY() - 70, image02);
        ikun03 = new Ikun(getX() + 150, getY() + 40, image03);
        ikun04 = new Ikun(getX() + 120, getY() + 130, image04);
        ikun05 = new Ikun(getX() + 50, getY() + 120, image05);
        ikun06 = new Ikun(getX() - 60, getY() + 110, image06);
        ikun07 = new Ikun(getX() - 70, getY() + 40, image07);

        ikuns.add(ikun01);
        ikuns.add(ikun02);
        ikuns.add(ikun03);
        ikuns.add(ikun04);
        ikuns.add(ikun05);
        ikuns.add(ikun06);
        ikuns.add(ikun07);

        for (int i = 0; i < ikuns.size(); i++) {
            new Thread(ikuns.get(i)).start();
        }
    }
}
