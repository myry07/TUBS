package chapter18.Tk03;

/**
 * @author myry
 * @date 2024-06-02 14:06
 *
 * 画3辆敌方坦克
 * 因为数量多 可以放到集合中
 * 考了多线程 放到vector中
 */

public class EnemyTank extends Tank {

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }
}
