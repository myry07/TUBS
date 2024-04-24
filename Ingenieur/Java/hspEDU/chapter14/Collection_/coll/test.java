package chapter14.Collection_.coll;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings({"all"})
public class test {
    public static void main(String[] args) {
        Collection c = new ArrayList();

        c.add(new Dog("小黄", 3));
        c.add(new Dog("小黑", 2));

        for(Object o : c) {
            System.out.print(o);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
