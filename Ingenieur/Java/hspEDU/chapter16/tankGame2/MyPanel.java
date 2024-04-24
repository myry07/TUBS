package chapter16.tankGame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author myry
 * @date 2024-08-27 15:08
 * 坦克大战的绘图区 毫无疑问 继承JPanel
 * 使坦克动起来 实现Key监听方法
 */

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;

    //定义敌人坦克 放入集合中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTanksSize = 3;//暂定坦克数量3

    public MyPanel() {
        hero = new Hero(100, 100);//x y坐标
        hero.setSpeed(2);

        for (int i = 0; i < enemyTanksSize; i++) {
            // 这样无法使得坦克初始时向下
            // enemyTanks.add(new EnemyTank(100 * (i + 1), 0));
            // 新增一个构造器
            enemyTanks.add(new EnemyTank(100 * (i + 1), 0, 2));
        }
    }

    @Override
    public void paint(Graphics g) {//g 是画笔
        super.paint(g);
        //g.setColor(Color.BLUE);
        g.fillRect(0, 0, 1000, 750);//填充矩形 默认黑色

        //画出自己的坦克
        drawTank(hero.getX() + 160, hero.getY() + 400, g, hero.getDirection(), 1);

        //画出敌人的坦克
        for (Object obj : enemyTanks) {
            EnemyTank et = (EnemyTank) obj;
            drawTank(et.getX(), et.getY(), g, et.getDirection(), 0);
        }
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
        //0 上
        //1 右
        //2 下
        //3 左
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
            case 1://向右
                //左右履带
                g.fill3DRect(x, y, 60, 10, false);//只是更具有立体感
                g.fill3DRect(x, y + 30, 60, 10, false);

                //中间身子 圆盖子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);

                //炮筒
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;

            case 2://向下
                //左右履带
                g.fill3DRect(x, y, 10, 60, false);//只是更具有立体感
                g.fill3DRect(x + 30, y, 10, 60, false);

                //中间身子 圆盖子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);

                //炮筒
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;

            case 3://向左
                //左右履带
                g.fill3DRect(x, y, 60, 10, false);//只是更具有立体感
                g.fill3DRect(x, y + 30, 60, 10, false);

                //中间身子 圆盖子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);

                //炮筒
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wsad键
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//W 上
            hero.setDirection(0);
            //hero.setY(hero.getY() - 1);
            //太过繁琐 不如在父类中封装一个方法 供子类调用
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//D 右
            hero.setDirection(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//S 下
            hero.setDirection(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//A 左
            hero.setDirection(3);
            hero.moveLeft();
        }
        //重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
