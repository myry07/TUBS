package chapter18.Tk04;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * @author myry
 * @date 2024-08-27 15:08
 * 坦克大战的绘图区 毫无疑问 继承JPanel
 * 使坦克动起来 实现Key监听方法
 */

//为了让Panel不停的重绘子弹 需要将MyPanel实现Runnable 当作线程使用
@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;

    //定义敌人坦克 放入集合中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTanksSize = 3;//暂定坦克数量3

    //定义集合 存放炸弹
    //当子弹击中敌人的坦克是 就加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() throws IOException {
        hero = new Hero(500, 300);//x y坐标
        hero.setSpeed(7);

        for (int i = 0; i < enemyTanksSize; i++) {
            // 这样无法使得坦克初始时向下
            // enemyTanks.add(new EnemyTank(100 * (i + 1), 0));
            // 新增一个构造器
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0, 2);
            //启动线程
            Thread thread = new Thread(enemyTank);
            thread.start();

            enemyTanks.add(enemyTank);
            //给敌人的坦克 加入子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            enemyTank.shots.add(shot);
            new Thread(shot).start();//别忘了启动线程 shot是线程
        }

        //初始化图片
        image1 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/Tk04/pngs/bomb1.png"));
        image2 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/Tk04/pngs/bomb2.png"));
        image3 = ImageIO.read(new File("/Users/myry/Documents/Pro.java/src/chapter18/Tk04/pngs/bomb3.png"));
    }

    @Override
    public void paint(Graphics g) {//g 是画笔
        super.paint(g);
        //g.setColor(Color.BLUE);
        g.fillRect(0, 0, 1000, 750);//填充矩形 默认黑色

        //画出自己的坦克
        if(hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
        }

        //画出hero打出的子弹
        //子弹得存活 并且不为null
//        if (hero.shot != null && hero.shot.isLive != false) {
//            g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
//        }

        //画出hero打出的子弹集合
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive != false) {
                g.draw3DRect(shot.x, shot.y, 1, 1, false);
            } else {//否则 拿出
                hero.shots.remove(shot);
            }
        }

        //如果bombs集合中有子弹 就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据life值画哪张图片
            if (bomb.life > 2) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 1) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让炸弹生命减少 使得离散->连续
            bomb.lifeDown();
            if (bomb.life == 0) {//用完就删了
                bombs.remove(bomb);
            }
        }

        //画出敌人的坦克 以及子弹
        for (Object obj : enemyTanks) {
            EnemyTank et = (EnemyTank) obj;

            //添加 如果坦克活着 才画
            if (et.isLive) {
                drawTank(et.getX(), et.getY(), g, et.getDirection(), 0);
                for (int i = 0; i < et.shots.size(); i++) {
                    //取出子弹对象
                    Shot shot = et.shots.get(i);
                    //绘制
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {//记得移除
                        et.shots.remove(shot);
                    }
                }
            }
        }
    }

    //编写方法 画出坦克
    //xy坐标 画笔g 方向direction type
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        //判断敌我
        switch (type) {
            case 0://敌方坦克
                g.setColor(Color.cyan);//青色
                break;
            case 1://我方坦克
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
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//D 右
            hero.setDirection(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//S 下
            hero.setDirection(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//A 左
            hero.setDirection(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        //J发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemy();
        }

        //重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每100毫秒重绘一次
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中坦克
            hitEnemyTank();

            //判断是否击中我方坦克
            hitHero();
            this.repaint();
        }
    }

    //集合子弹 应该全部判断
    public void hitEnemyTank() {
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);

            //遍历我方子弹
            if (shot != null && shot.isLive) {//务必保证坦克活着
                //遍历敌人坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }



    //编写方法 判断我方坦克是否击中地方的
    //放入run方法重绘
    public void hitTank(Shot s, Tank tank) {
        switch (tank.getDirection()) {
            //往上往下是一样的大小
            case 0:
            case 2:
                if (s.x > tank.getX() && s.x < tank.getX() + 40
                        && s.y > tank.getY() && s.y < tank.getY() + 60) {
                    //子弹与坦克都消亡
                    s.isLive = false;
                    tank.isLive = false;
                    enemyTanks.remove(tank);

                    //创建Bomb对象 加入到bombs中
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            //右左一样
            case 1:
            case 3:
                if (s.x > tank.getX() && s.x < tank.getX() + 60
                        && s.y > tank.getY() && s.y < tank.getY() + 40) {
                    s.isLive = false;
                    tank.isLive = false;
                    enemyTanks.remove(tank);

                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    //编写方法 判断敌方坦克是否击中我方的
    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            // 取出敌人tanke
            EnemyTank enemyTank = enemyTanks.get(i);
            //敌人坦克 有多颗子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                //进行判断
                if(hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }
}
