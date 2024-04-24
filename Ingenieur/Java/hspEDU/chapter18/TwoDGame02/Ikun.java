package chapter18.TwoDGame02;

import java.awt.*;
import java.util.Vector;

@SuppressWarnings({"all"})
public class Ikun extends User implements Runnable {
    Shot shot = new Shot();
    Vector<Shot> shots = new Vector<>();
    private int x;
    private int y;
    private int speed = 10;
    private int direction;
    private Image image;
    private boolean isLive = true;

    public Ikun() {
    }

    public Ikun(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;

    }

    public Ikun(int x, int y, int direction, Image image) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.image = image;
    }

    public void getHelp() {
    }

    @Override
    public void run() {
        while (true) {
            try {
                attack();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int num = (int) (Math.random() * 4);
            int move = (int) (Math.random() * 3) + 2;

            //根据方向 改变xy坐标
            switch (num) {
                case 0:
                    if (this.y > 0) {
                        y -= move;
                    }
                    break;
                case 1:
                    if (this.x + 50 < 1000) {
                        x += move;
                    }
                    break;
                case 2:
                    if (this.y + 50 < 700) {
                        y += move;
                    }
                    break;
                case 3:
                    if (this.x > 150) {
                        x -= move;
                    }
                    break;
            }
            //调试坐标
            if (!(x >= 150 && x <= 1000 & y >= 0 && y <= 700 && isLive)) {
                isLive = false;
                break;
            }
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean isLive() {
        return isLive;
    }

    @Override
    public void setLive(boolean live) {
        isLive = live;
    }

    public void attack() {
        if (getHp() > 0 && shots.size() < 100) {
            switch (getDirection()) {
                case 0://向上
                    shot = new Shot(getX() + 25, getY() - 30, 0);
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
    }
}
