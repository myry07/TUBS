package H3;

public class PF1 {
    public static void main(String[] args) {

        //1.创建商品
        Ware w0 = new Ware(0, "杜蕾斯", 70);
        Ware w1 = new Ware(1, "冈本", 40);
        Ware w2 = new Ware(2, "情趣内衣", 10);
        Ware w3 = new Ware(3, "成人玩具", 220);
        Ware w4 = new Ware(4, "潘婷", 90);

        Ware[] waren = new Ware[5];
        waren[0] = w0;
        waren[1] = w1;
        waren[2] = w2;
        waren[3] = w3;
        waren[4] = w4;

        //创建收钱系统
        Muenzsystem ms = new Muenzsystem();

        //创建自动售货机
        Automat automat = new Automat(ms, waren);
        automat.getWare();//2.展示商品

        //3.投钱
        if(automat.insertCoin(3)) {
            automat.getMs().setCurrentCoins(3);
        }

        if(automat.insertCoin(10)) {
            automat.getMs().setCurrentCoins(10);
        }

        if(automat.insertCoin(200)) {
            automat.getMs().setCurrentCoins(200);
        }

        //查看投入多少钱
        System.out.println(automat.getMs().get_Money());

        //4.退钱
        automat.getMs().reset();
        System.out.println(automat.getMs().get_Money());

        //5.投有效的钱并购买商品
        int new_money = 0;
        if(automat.insertCoin(10)) {
            automat.getMs().setCurrentCoins(10);
        }

        if(automat.insertCoin(200)) {
            automat.getMs().setCurrentCoins(200);
        }

        int money = automat.getMs().get_Money();
        System.out.println("目前余额: " + money);
        if(automat.getMs().buy(money, w4)) {
            new_money = automat.confirm(money, 4);
            System.out.println("目前余额: " + new_money);
        }

        //5.退钱
        int ab_money;
        ab_money = automat.absort(new_money);
        System.out.println("目前余额: " + ab_money);
    }
}
