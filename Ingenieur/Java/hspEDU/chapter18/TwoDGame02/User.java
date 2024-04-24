package chapter18.TwoDGame02;

import java.awt.*;

@SuppressWarnings({"all"})
public abstract class User implements Skills {
    private int x;
    private int y;
    private int speed;
    private int direction;
    private String name;
    private int hp;
    private int hit;
    private String hobby;
    private Image image;
    private boolean isLive = true;

    public User() {}

    public User(int x, int y, int speed, int direction, Image image, int i) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.hit = hit;
        this.image = image;
    }

    public User(int x, int y, String name, int hp, int hit , String hobby, Image image, int speed) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.hp = hp;
        this.hit = hit;
        this.hobby = hobby;
        this.image = image;
        this.speed = speed;
    }

    public User(int x, int y, String name, int hp, String hobby, Image image, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.name = name;
        this.hp = hp;
        this.hobby = hobby;
        this.image = image;
    }

    public void move() {
        int time = (int) (Math.random() * 90) + 1;
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

    public void attack() {}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void moveUp() {//向上
        y -= speed;
    }

    public void moveDown() {//向下
        y += speed;
    }

    public void moveLeft() {//向左
        x -= speed;
    }

    public void moveRight() {//向右
        x += speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

}
