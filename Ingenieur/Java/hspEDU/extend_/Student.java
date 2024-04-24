package extend_;

public class Student {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void shouInfo() {
        System.out.println("学生名字: " + name +  " 学生年龄: " + age + " 学生成绩: " + score);
    }
}
