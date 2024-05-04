package H3;

import java.util.Random;

/**
 * 一个银行持有30个Account
 * 在update函数的帮助下刷新Konten
 * <p>
 * Sparkonto有利息 Girokonto有信息，如果余额少于0
 * <p>
 * Bank有开户函数 open(boolean) 那种账户类型被开开
 * Bank有关户函数 close(int)
 * <p>
 * 存钱 deposit(int, double)
 * 取钱 withdraw(int, double)
 */
public class Bank {
    Account[] accounts;

    public Bank() {

    }

    public Bank(Account[] accounts) {
        this.accounts = accounts;
    }

    //update函数
    //更新20个银行账户 包含instanceof
    public void update() {
        Random r = new Random();

        Account as0 = new savingsAccount(100, r.nextInt(1000) + 10000, 3);
        Account as1 = new savingsAccount(101, r.nextInt(1000) + 10000, 3);
        Account as2 = new savingsAccount(102, r.nextInt(1000) + 10000, 3);
        Account as3 = new savingsAccount(103, r.nextInt(1000) + 10000, 3);
        Account as4 = new savingsAccount(104, r.nextInt(1000) + 10000, 3);
        Account as5 = new savingsAccount(105, r.nextInt(1000) + 10000, 3);
        Account as6 = new savingsAccount(106, r.nextInt(1000) + 10000, 3);
        Account as7 = new savingsAccount(107, r.nextInt(1000) + 10000, 3);
        Account as8 = new savingsAccount(108, r.nextInt(1000) + 10000, 3);
        Account as9 = new savingsAccount(109, r.nextInt(1000) + 10000, 3);

        Account ac0 = new currentAccount(200, r.nextInt(1000) + 5000, 1000);
        Account ac1 = new currentAccount(201, r.nextInt(1000) + 5000, 1000);
        Account ac2 = new currentAccount(202, r.nextInt(1000) + 5000, 1000);
        Account ac3 = new currentAccount(203, r.nextInt(1000) + 5000, 1000);
        Account ac4 = new currentAccount(204, r.nextInt(1000) + 5000, 1000);
        Account ac5 = new currentAccount(205, r.nextInt(1000) + 5000, 1000);
        Account ac6 = new currentAccount(206, r.nextInt(1000) + 5000, 1000);
        Account ac7 = new currentAccount(207, r.nextInt(1000) + 5000, 1000);
        Account ac8 = new currentAccount(208, r.nextInt(1000) + 5000, 1000);
        Account ac9 = new currentAccount(209, r.nextInt(1000) + 5000, 1000);

        Account[] as = new savingsAccount[10];
        as[0] = as0;
        as[1] = as1;
        as[2] = as2;
        as[3] = as3;
        as[4] = as4;
        as[5] = as5;
        as[6] = as6;
        as[7] = as7;
        as[8] = as8;
        as[9] = as9;

        Account[] ac = new currentAccount[10];
        ac[0] = ac0;
        ac[1] = ac1;
        ac[2] = ac2;
        ac[3] = ac3;
        ac[4] = ac4;
        ac[5] = ac5;
        ac[6] = ac6;
        ac[7] = ac7;
        ac[8] = ac8;
        ac[9] = ac9;

        this.accounts = new Account[20];
        for (int i = 0; i < accounts.length; i++) {
            if (i < 10) {
                accounts[i] = as[i];
            } else {
                accounts[i] = ac[i - 10];
            }
        }

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] instanceof savingsAccount) {
                savingsAccount temp_sa = (savingsAccount) accounts[i];
                temp_sa.setInterestRate(3);
            } else {
                currentAccount temp_ca = (currentAccount) accounts[i];
                temp_ca.setLimit(1000);
            }
        }
    }

    //开户函数
    //confirm 开的是Spar还是Giro
    //int 返回账户号
    public int open(boolean confirm) {
        if (confirm) {//true --> Sparkonto
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] instanceof savingsAccount) {//查找Sparkonto
                    if (!(accounts[i].getState().equals("已开户"))) {//查找未开户Konto
                        accounts[i].setState("已开户");
                        return accounts[i].getAccnum();
                    }
                }
            }
        } else {//false --> Girokonto
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] instanceof currentAccount) {//查找Girokonto
                    if (!(accounts[i].getState().equals("已开户"))) {//查找未开户Konto
                        accounts[i].setState("已开户");
                        return accounts[i].getAccnum();
                    }
                }
            }
        }
        return 0;
    }

    //关户函数
    //int 关户账户号
    public boolean close(int account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccnum() == account) {//找到该账户
                if (accounts[i].getState().equals("已开户")) {//检测是否真的开户
                    accounts[i].setState("未开户");
                    System.out.println("关户成功");
                    return true;
                }
            }
        }
        System.out.println("错误的账户号或未开户");
        return false;
    }

    //存钱
    public void deposit(int account, double balance) {
        for (int i = 0; i < accounts.length; i++) {
            if (account == accounts[i].getAccnum()) {
                accounts[i].deposit(balance);
            }
        }
    }

    //取钱
    public void withdraw(int account, double balance) {
        for (int i = 0; i < accounts.length; i++) {
            if (account == accounts[i].getAccnum()) {
                accounts[i].withdraw(balance);
            }
        }
    }

    //<-----------get&set----------->
    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}
