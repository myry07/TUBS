package chapter18.Tk03;

/**
 * @author myry
 * @date 2024-09-03 22:09
 * <p>
 * 子弹类
 * 自动运动 -> 线程
 */

public class Shot implements Runnable {
    int x;//坐标毫无疑问
    int y;
    int direction = 0;//方向
    int speed = 2;//速度
    boolean isLive = true;//检测子弹是否还存活

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    @Override
    public void run() {//射击行为
        while (true) {
            //线程休眠 否则就是唰一下没了
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
            System.out.println("子弹坐标 x " + x + " y " + y);
            //何时终止 超出面板
            //this.setSize(1000, 750);
            if (!(x >= 0 && x <= 1000 & y >= 0 && y <= 750)) {
                isLive = false;
                break;
            }
        }

    }
}
