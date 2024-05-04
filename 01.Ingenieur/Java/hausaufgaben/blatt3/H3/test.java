package H3;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        //创建商品
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
        automat.getWare();//展示商品


        //投钱
        System.out.println("请投币");
        int[] money_show = automat.getMs().getValidCoins();
        for (int i = 0; i < money_show.length; i++) {
            System.out.print(money_show[i] + " ");
        }
        Scanner s = new Scanner(System.in);
        System.out.println();

        //投钱循环
        do {
            int money = s.nextInt();
            if (automat.insertCoin(money)) {//检测投入的钱是否有效
                automat.getMs().setCurrentCoins(money);//投入
            } else {
                System.out.println("无效的钱");
            }

            System.out.println("还想继续投币吗 y/n");
            char answer = s.next().charAt(0);
            if (answer != 'y') {
                break;
            } else {
                System.out.println("请继续投币");
            }
        } while (true);

        //检测投入多少
        System.out.println("目前投入: " + automat.getMs().get_Money());

        //购买商品
        System.out.println("请选择商品ID 0-4");
        int money = automat.getMs().get_Money();
        do {
            int id = s.nextInt();
            if (automat.select(id)) {//检测输入的id输否存在
                Ware w_temp = new Ware();
                for (int i = 0; i < waren.length; i++) {
                    if(waren[i].getId() == id) {
                        w_temp = waren[i];//根据id找到物品
                    }
                }

                System.out.println("已选择商品: " + w_temp);

                if (automat.getMs().buy(money, w_temp)) {//检测是否可以购买 钱是否足够
                    money = automat.confirm(money, id);
                    System.out.println("目前余额: " + money);
                } else {//如果钱不够
                    System.out.println("钱不够");
                }
            } else {//如果不存在
                System.out.println("错误的id");
            }

            System.out.println("你还想继续吗 y/n");
            char answer = s.next().charAt(0);
            if(answer != 'y') {
                automat.absort(money);
                System.out.println("目前余额: " + money);
                break;
            } else {
                System.out.println("请选择商品");
            }
        }while (true);
    }
}
