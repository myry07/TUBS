package chapter14.Collection_.coll;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class list_ {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("jack");
        list.add(10);
        list.add(true);

        System.out.println(list);
    }
}
