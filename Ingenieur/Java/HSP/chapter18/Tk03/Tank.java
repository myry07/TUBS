package chapter18.Tk03;

/**
 * @author myry
 * @date 2024-05-27 15:05
 * 每个坦克都有不同的大小 速度 所以抽象出一个父类 以供继承
 *
 * 左履带 左上角是xy起始点 宽10 高60
 * 身子   x+10 y+10     宽20 高40
 * 右履带 左上角x+30 y    宽10 高60
 * 圆盖子   x+10 y+20    宽20 高20
 * 炮筒    x+20 y+30    x+20 y
 */

@SuppressWarnings({"all"})
public class Tank {
    private int x;
    private int y;
    private int direction;//为了改变坦克方向 增加一个属性 0 1 2 3
    private int speed = 1;//初始速度默认=1

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank(int x, int y, int direction) {
        this.x = x;
        this.y = y;
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
}
