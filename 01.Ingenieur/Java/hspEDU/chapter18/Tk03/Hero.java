package chapter18.Tk03;

/**
 * @author myry
 * @date 2024-06-27 15:06
 * 我方坦克 继承父类
 */

public class Hero extends Tank {
    //定义一个Shot 作为坦克发射子弹的对象
    Shot shot = null;
    public Hero(int x, int y) {
        super(x, y);
    }

    //开火方法
    public void shotEnemy() {
        //创建shot对象 根据我方坦克位置
        //public Shot(int x, int y, int direction) {
        //还是需要switch判断 因为炮筒位置不定
        switch (getDirection()) {
            case 0://向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://向右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2://向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3://向左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        Thread t = new Thread(shot);
        t.start();//启动线程
    }
}
