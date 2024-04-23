package chapter14.Map_.map_;

import java.util.HashMap;

@SuppressWarnings({"all"})
public class map_ {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("no1", "hsp");
        hashMap.put("no2", "wjq");
        hashMap.put("no1", "ch");
        hashMap.put("no3", "ch");

        System.out.println(hashMap);

        System.out.println(hashMap.get("no1"));



    }
}
