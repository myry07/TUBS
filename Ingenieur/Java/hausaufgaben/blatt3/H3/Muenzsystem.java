package H3;

public class Muenzsystem {//硬币系统
    private int[] validCoins = {1, 2, 5, 10, 20, 50, 100, 200};
    private int[] insertedCoins;
    private int[] currentCoins = {0, 0, 0, 0, 0, 0, 0, 0};

    public Muenzsystem() {

    }

    public Muenzsystem(int[] validCoins, int[] insertedCoins, int[] currentCoins) {
        this.validCoins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};//可投入的Geld
        this.insertedCoins = new int[8];//累计多少Geld被投入
        this.currentCoins = new int[8];//分别有多少Geld 被该客户投入
    }

    public boolean insert(int money) {//检查投币是否成功
        if (money >= 0) {
            return true;
        }
        return false;
    }

    public void reset() {//退钱
        System.out.println("退款");
        for (int i = 0; i < currentCoins.length; i++) {
            currentCoins[i] = 0;
        }
    }

    public int get_Money() {//投币多少
        int money = 0;
        for (int i = 0; i < validCoins.length; i++) {
            money += validCoins[i] * currentCoins[i];
        }
        return money;
    }

    public boolean buy(int money, Ware w) {//检测可否购买
        if (money >= w.getPrice()) {
            return true;
        }

        return false;
    }


    //<-----------get&set----------->
    public int[] getValidCoins() {
        return validCoins;
    }

    public void setValidCoins(int[] validCoins) {
        this.validCoins = validCoins;
    }

    public int[] getInsertedCoins() {
        return insertedCoins;
    }

    public void setInsertedCoins(int[] insertedCoins) {
        this.insertedCoins = insertedCoins;
    }

    public int[] getCurrentCoins() {
        return currentCoins;
    }

    public void setCurrentCoins(int money) {
        if (insert(money)) {
            switch (money) {
                case 1:
                    currentCoins[0] += 1;
                    break;
                case 2:
                    currentCoins[1] += 1;
                    break;
                case 5:
                    currentCoins[2] += 1;
                    break;
                case 10:
                    currentCoins[3] += 1;
                    break;
                case 20:
                    currentCoins[4] += 1;
                    break;
                case 50:
                    currentCoins[5] += 1;
                    break;
                case 100:
                    currentCoins[6] += 1;
                    break;
                case 200:
                    currentCoins[7] += 1;
                    break;
            }
        }
    }
}
