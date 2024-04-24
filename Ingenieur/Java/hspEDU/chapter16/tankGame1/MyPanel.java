package chapter16.tankGame1;

import javax.swing.*;
import java.awt.*;

/**
 * @author myry
 * @date 2024-08-27 15:08
 * 坦克大战的绘图区 毫无疑问 继承JPanel
 */

public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;
    public MyPanel() {
        hero = new Hero(100, 100);//x y坐标
    }

    @Override
    public void paint(Graphics g) {//g 是画笔
        super.paint(g);
        //g.setColor(Color.WHITE);
        g.fillRect(0, 0 , 1000, 750);//填充矩形 默认黑色

        drawTank(hero.getX(), hero.getY(), g, 0, 0);
        drawTank(hero.getX() + 60, hero.getY(), g, 0, 1);
    }

    //编写方法 画出坦克
    //xy坐标 画笔g 方向direction type
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        //判断敌我
        switch (type) {
            case 0://我方坦克
                g.setColor(Color.cyan);//青色
                break;
            case 1://地方坦克
                g.setColor(Color.yellow);//黄色
                break;
        }

        //根据方向绘制坦克
        switch (direction) {
            case 0://向上
                //左右履带
                g.fill3DRect(x, y, 10, 60, false);//只是更具有立体感
                g.fill3DRect(x + 30, y, 10, 60, false);

                //中间身子 圆盖子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);

                //炮筒
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
        }

    }
}
