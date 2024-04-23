package chapter15.generic;

public class e {
    public static void main(String[] args) {
        Person<String> hsp = new Person<String>("hsp");
        Person<Integer> hip = new Person<Integer>(1);

        System.out.println(hsp.s.getClass());
        System.out.println(hip.s.getClass());

    }
}

class Person<E> {
    E s;

    public Person(E s) {
        this.s = s;
    }


}
