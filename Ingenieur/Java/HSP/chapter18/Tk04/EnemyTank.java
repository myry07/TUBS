package chapter18.Tk04;

import java.util.Vector;

/**
 * @author myry
 * @date 2024-06-02 14:06
 * <p>
 * 画3辆敌方坦克
 * 因为数量多 可以放到集合中
 * 考了多线程 放到vector中
 */

@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {

    //在敌人坦克类中 使用Vector保存多个shot 多线程 Vector安全
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    public void run() {
        int time = (int) (Math.random() * 170) + 1;
        //敌人坦克自由移动
        //感情自然流露 写成线程
        while (true) {
            //根据坦克方向继续移动

            //如果shot的size==0 无子弹
            //那么创建可以并且启动
            if (isLive && shots.size() < 10) {
                Shot s = null;
                //判断坦克方向 创建对应的子弹
                switch (getDirection()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }

            switch (getDirection()) {
                case 0://上
                    for (int i = 0; i < time; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {//务必休眠 否则右bug
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1://右
                    for (int i = 0; i < time; i++) {
                        if (getX() + 60 < 1000) {
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
                        if (getY() + 60 < 750) {
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
                        if (getX() > 0) {
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
            //随机改变方向 [0,4)
            setDirection((int) (Math.random() * 4));
            //一旦写线程 务必搞清楚 什么时候退出
            //在创建时 启动
            if (isLive == false) {
                break;
            }
        }
    }
}
