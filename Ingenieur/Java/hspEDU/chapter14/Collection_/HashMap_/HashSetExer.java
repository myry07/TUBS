package chapter14.Collection_.HashMap_;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashSetExer {
    public static void main(String[] args) {

        Employee e1 = new Employee("milan", 18);
        Employee e2 = new Employee("smith", 28);
        Employee e3 = new Employee("milan", 18);

        HashSet hashSet = new HashSet();
        hashSet.add(e1);//t
        hashSet.add(e2);//t
        hashSet.add(e3);//t  重写之后 f

        System.out.println(hashSet);


    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //如果name 和 age 一样 返回相同的hash值

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
