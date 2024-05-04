package chapter14.Collection_.set;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class set_ {
    public static void main(String[] args) {
        Set s = new HashSet();

        s.add("3");
        s.add("2");
        s.add("1");
        s.add("1");
        s.add("2");
        s.add("2");
        s.add(null);
        s.add(null);

        System.out.println(s);

        }
    }
