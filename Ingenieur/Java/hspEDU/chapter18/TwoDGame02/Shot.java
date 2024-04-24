package chapter18.TwoDGame02;

import java.awt.*;

@SuppressWarnings({"all"})
public class Shot implements Runnable {
    private int x;
    private int y;
    private int speed = 10;
    private int direction;
    private Image image;
    private boolean isLive = true;

    public Shot() {
    }

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Shot(int x, int y, int direction, Image image) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.image = image;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //根据方向 改变xy坐标
            switch (direction) {
                case 0://向上
                    y -= speed;
                    break;
                case 1://向右
                    x += speed;
                    break;
                case 2://向下
                    y += speed;
                    break;
                case 3://向左
                    x -= speed;
                    break;
            }
            //调试坐标
            if (!(x >= 150 && x <= 1000 & y >= 0 && y <= 700 && isLive)) {
                isLive = false;
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
