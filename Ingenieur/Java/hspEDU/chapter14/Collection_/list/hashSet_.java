package chapter14.Collection_.list;

import java.util.HashSet;

/**
 * @author myry
 * @date 2024-41-31 17:41
 * HashSet
 */

@SuppressWarnings({"all"})
public class hashSet_ {
    public static void main(String[] args) {
//        HashSet
                //底层是HashMap
        //public HashSet() {
        //        map = new HashMap<>();
        //    }

        HashSet set = new HashSet();

        System.out.println(set.add("john"));//t
        System.out.println(set.add("lucy"));//t
        System.out.println(set.add("john"));//f
        System.out.println(set.add("jack"));//t
        System.out.println(set.add("rose"));//t

        set.remove("john");

        System.out.println(set);//[rose, lucy, jack]


        set = new HashSet();

        set.add("tom");//t
        set.add("tom");//f

        set.add(new Dog("lucy"));//t
        set.add(new Dog("lucy"));//t

        System.out.println(set);//[lucy, lucy, tom]

        set.add((new String("hsp")));
        set.add((new String("hsp")));


    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
