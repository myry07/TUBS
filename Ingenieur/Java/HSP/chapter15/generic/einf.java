package chapter15.generic;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class einf {
    public static void main(String[] args) {

        //传统方法
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("小黄", 1));
        arrayList.add(new Dog("发财", 5));

        arrayList.add(new Cat("可乐", 5));//这就出问题了


        for (Object obj : arrayList) {
            Dog d = (Dog) obj;
            System.out.println(d.getName() + " - " +d.getAge());
        }

        ArrayList<Dog> arrayList1 = new ArrayList<Dog>();



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

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
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
