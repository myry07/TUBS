package poly;

import java.lang.reflect.AnnotatedArrayType;

public class Poly01 {
    public static void main(String[] args) {
        Master m = new Master("王假期");

        Dog d = new Dog("王小龙");
        Bone b = new Bone("大棒骨");
        m.feed(d,b);

        Cat c = new Cat("王大龙");
        Fisch f = new Fisch("黄花鱼");
        m.feed(c,f);

        Animal dog = new Dog("王小龙");
        Food bone = new Bone("大棒骨");
        m.feed(dog, bone);

        Animal pig = new Pig("王中龙");
        Food rice = new Rice("主人吃剩的米饭");
        m.feed(pig, rice);

    }
}
