package chapter15.detai;

public class d {
    public static void main(String[] args) {
        Pig<String> ps = new Pig<String>("ps");
        Pig<Object> po = new Pig<Object>("ps");
        Pig<Object> pi = new Pig<Object>(123);
    }
}

class Pig<E> {
    E e;

    public Pig(E e) {
        this.e = e;
    }
}