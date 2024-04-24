package chapter18.TwoDGame02;

import java.awt.*;
import java.util.Vector;

@SuppressWarnings({"all"})
public class EnemyUser extends User implements Runnable {
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();

    public EnemyUser(int x, int y, String name, int hp, int hit, String hobby, Image image, int speed) {
        super(x, y, name, hp, hit, hobby, image, speed);
    }

    public void attack() {
        if (getHp() > 0 && shots.size() < 100) {
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
    }

    @Override
    public void move() {
        int time = (int) (Math.random() * 70) + 1;
        switch (getDirection()) {
            case 0://上
                for (int i = 0; i < time; i++) {
                    if (getY() > 0) {
                        moveUp();
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 1://右
                for (int i = 0; i < time; i++) {
                    if (getX() + 100 < 1000) {
                        moveRight();
                    }
                    try {//务必休眠 否则右bug
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 2://下
                for (int i = 0; i < time; i++) {
                    if (getY() + 100 < 700) {
                        moveDown();
                    }
                    try {//务必休眠 否则右bug
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 3://左
                for (int i = 0; i < time; i++) {
                    if (getX() > 150) {
                        moveLeft();
                    }
                    try {//务必休眠 否则右bug
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            //随机改变方向
        }
    }

    @Override
    public void run() {
        while (true) {
            move();
            attack();
            setDirection((int) (Math.random() * 4));
            if (getHp() == 0) {
                break;
            }
        }
    }

    public void getHelp() {
    }
}
