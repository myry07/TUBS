package H3;

public class Automat {
    private Muenzsystem ms;
    private Ware[] waren;

    public Automat(Muenzsystem ms, Ware[] waren) {
        this.ms = ms;
        this.waren = waren;
    }

    public boolean insertCoin(int muenze) {//检测投入的硬币 是否符合系统标准
        for (int i = 0; i < ms.getValidCoins().length; i++) {
            if (ms.getValidCoins()[i] == muenze) {
                return true;
            }
        }
        return false;
    }

    public void getWare() {//罗列商品与其ID
        for (int i = 0; i < waren.length; i++) {
            System.out.println(waren[i]);
        }
    }

    public boolean select(int id) {//购买与id相符合的商品
        for (int i = 0; i < waren.length; i++) {
            if (id == waren[i].getId()) {
                return true;
            }
        }
        return false;
    }

    public int confirm(int money, int id) {
        for (int i = 0; i < waren.length; i++) {
            if(id == waren[i].getId()) {
                money -= waren[i].getPrice();
                System.out.println("购买成功");
            }
        }
        return money;
    }


    public int absort(int money) {//退钱
        ms.reset();
        return 0;
    }

    //<-----------get&set----------->
    public Muenzsystem getMs() {
        return ms;
    }

    public void setMs(Muenzsystem ms) {
        this.ms = ms;
    }

    public Ware[] getWaren() {
        return waren;
    }

    public void setWaren(Ware[] waren) {
        this.waren = waren;
    }
}
