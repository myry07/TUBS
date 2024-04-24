package chapter18.Tk04;

import Dynamik.B;

public class Bomb {
    int x, y;
    int life = 3;
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
}
