package poly.detai;

import poly.Animal;

public class test {
    public static void main(String[] args) {
        Anima c = new Cat();
        c.eat();
        c.sleep();

        Cat cc = (Cat)c;
        cc.ca();
    }
}

