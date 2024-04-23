package H3;

public class savingsAccount extends Account {//省钱账户
    //Sparkonto
    //该账户至少有余额10000

    private double interestRate;//利率 3%

    public savingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public savingsAccount(int accnum, double balance, double interestRate) {
        super(accnum, balance);
        this.interestRate = interestRate;
    }

    public double interest() {//利息
        return (getBalance() * this.interestRate) / 100;
    }

    public String toString() {
        return "省钱账户: " + getAccnum() + " 余额: " + getBalance() + " 利率: " + getInterestRate()
                + " 利息: " + (getBalance() * getInterestRate() / 100);
    }

    //<-----------get&set----------->
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
