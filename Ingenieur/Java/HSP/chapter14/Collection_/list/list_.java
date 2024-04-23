package chapter14.Collection_.list;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class list_ {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");

        list.add(2, "hsp");
        System.out.println(list.get(5));
        list.remove(6);
        list.set(7,"2");

        System.out.println(list);
    }
}
