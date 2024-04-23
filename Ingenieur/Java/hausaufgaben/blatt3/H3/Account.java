package H3;

public class Account {//银行账户
    private int accnum;//银行账户号码
    private double balance;//银行余额
    private String state = "未开户";//开户状态

    public Account() {

    }

    public Account(int accnum, double balance) {
        this.accnum = accnum;
        this.balance = balance;
    }

    public boolean deposit(double geld) {//将非负的钱 存入账户
        if (geld >= 0) {
            this.balance += geld;
            return true;
        }
        return false;
    }

    public boolean withdraw(double geld) {//将非负的钱 提出账户
        if(geld >= 0 && geld <= getBalance()) {
            double money = getBalance();
            setBalance(money - geld);
            return true;
        }
        return false;
    }

    public String toString() {
        return "银行账户: " + getAccnum() + " 余额: " + getBalance();
    }


    //<-----------get&set----------->
    public int getAccnum() {
        return accnum;
    }

    public void setAccnum(int accnum) {
        this.accnum = accnum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
