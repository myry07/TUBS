package H3;

public class currentAccount extends Account {//转账账户
    //Girokonto
    //有限制转账多少
    private double limit;//限制 -1000

    public currentAccount(double limit) {
        this.limit = limit;
    }

    public currentAccount(int accnum, double balance, double limit) {
        super(accnum, balance);
        this.limit = limit;
    }

    public boolean withdraw(double geld) {//将非负的钱 提出账户
        if(geld >= 0) {
            double money = getBalance();
            setBalance(money - geld);
            if((money - geld) < 0) {
                System.out.println("转账账户 " + getAccnum() +  " 余额小于0");
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return "转账账户: " + getAccnum() + " 余额: " + getBalance() + " 限制: " + getLimit();
    }

    //<-----------get&set----------->
    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
