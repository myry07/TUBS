package chapter18.TwoDGame02;

@SuppressWarnings({"all"})
public class Bomb {
    private int x;
    private int y;
    private int life = 3;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //根据炸弹的不同生命 显示不同的图片
    public void lifeDown() {
        if(life > 0) {
            life--;
        } else {
            isLive = false;
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
