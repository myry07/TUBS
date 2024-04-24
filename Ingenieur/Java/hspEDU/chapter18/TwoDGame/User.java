package chapter18.TwoDGame;

import java.awt.*;

@SuppressWarnings({"all"})
public class User {
    private Image image;
    private String name;
    private int age;
    private String hobby;
    private int x;
    private int y;
    private int speed = 7;
    private int direction = 0;

    public User() {}

    public User(int x, int y, Image image, String name, int age, String hobby) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public User(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public User(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

}
