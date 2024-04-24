package encap;

public class encap01 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("wxl");
        p1.setAge(88);
        p1.setSalary(20);
        p1.setJob("厕所清洁员");

        System.out.println(p1);

    }
}

class Person {
    public String name;
    private int age;
    private double salary;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 1 && age < 120) {
            this.age = age;
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return "名字: " + name +
                " 年龄: " + age +
                " 薪水: " + salary +
                " 工作: " + job;

    }
}
