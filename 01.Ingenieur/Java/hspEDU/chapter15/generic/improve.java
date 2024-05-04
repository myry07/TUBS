package chapter15.generic;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class improve {
    public static void main(String[] args) {

        ArrayList<Dog> arrayList = new ArrayList<Dog>();

        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("小黄", 1));
        arrayList.add(new Dog("发财", 5));

        //arrayList.add(new Cat("可乐", 5));//编译器直接报错

        for (Dog d : arrayList) {
            System.out.println(d.getName() + " - " + d.getName());
        }
    }
}
