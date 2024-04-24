package PolyParameter;

public class wo extends Employee {

    public wo(String name, int salary) {
        super(name, salary);
    }

    @Override
    public String getAnnual() {
        return "员工 " + super.getAnnual();
    }

    public void work() {
        System.out.println(getName() + " 正在工作");
    }
}

