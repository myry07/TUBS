package PolyArry;

public class Student extends Person{
    private int score;
    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }
    public String say() {
        return super.say() + " 成绩" + score;
    }

    public String study() {
        return "我爱学吃屎";
    }
}
