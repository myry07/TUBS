package PolyParameter;

public class Mana extends Employee {
    private int bonus;

    public Mana(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String getAnnual() {
        return "经理 " + super.getAnnual() + " 奖金 " + getBonus();
    }

    public void manager() {
        System.out.println(getName() + " 正在管理");
    }
}
