package H3;

import java.util.Random;

public class PF2 {
    public static void main(String[] args) {
        Random r = new Random();
        Bank sparkasse = new Bank();


        //使用每个账户转账
        sparkasse.update();
        System.out.println("<----------转账前---------->");
        for (int i = 0; i < sparkasse.getAccounts().length; i++) {
            System.out.println(sparkasse.getAccounts()[i]);
        }

        for (int i = 0; i < sparkasse.getAccounts().length; i++) {
            double balance = sparkasse.getAccounts()[i].getBalance();
            double geldbetrag = r.nextInt(1000) + 5000;
            sparkasse.getAccounts()[i].setBalance(balance - geldbetrag);
        }

        System.out.println("<----------转账后---------->");
        for (int i = 0; i < sparkasse.getAccounts().length; i++) {
            System.out.println(sparkasse.getAccounts()[i]);
        }

        //使用每个账户取钱 省钱账户 >100 转账账户 <0
        for (int i = 0; i < sparkasse.getAccounts().length; i++) {
            if(sparkasse.getAccounts()[i] instanceof currentAccount) {
                currentAccount temp_ca = (currentAccount) sparkasse.getAccounts()[i];
                temp_ca.withdraw(1000);
            }
        }

        System.out.println("<----------取钱后---------->");
        for (int i = 0; i < sparkasse.getAccounts().length; i++) {
            System.out.println(sparkasse.getAccounts()[i]);
        }


    }
}
