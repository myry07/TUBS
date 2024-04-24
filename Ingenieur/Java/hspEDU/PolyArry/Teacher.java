package PolyArry;

public class Teacher extends Person{
    private int salary;
    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public String say() {
        return super.say() + " 工资" + salary;
    }

    public String study() {
        return "我爱教吃屎";
    }
}
