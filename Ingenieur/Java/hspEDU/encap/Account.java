package encap;

public class Account {
    private String name;
    private int money;
    private String code;

    public Account() {
    }

    public Account(String name, int money, String code) {
        setName(name);
        setMoney(money);
        setCode(code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if(money >= 20) {
            this.money = money;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if(code.length() == 6) {
            this.code = code;
        } else {
            System.out.println("默认密码 666666");
            this.code = "666666";
        }
    }

    public String toString() {
        return "名字: " + name +
                " 余额: " + money +
                " 密码: " + code;
    }
}
