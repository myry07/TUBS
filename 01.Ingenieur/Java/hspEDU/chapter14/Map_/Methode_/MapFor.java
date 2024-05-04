package chapter14.Map_.Methode_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("邓超", "孙俪");//替换
        map.put("王宝强", "马融");//OK
        map.put("宋喆", "马融");//OK
        map.put("流凌波", null);//OK
        map.put(null, "刘亦菲");//OK
        map.put("关晓彤", "鹿晗");//OK

        //1.所以的key 通过key取出Value
        Set keyset = map.keySet();

        for(Object obj : keyset) {
            System.out.println(obj + "-" + map.get(obj));
        }

        //2. 取出value
        Collection value = map.values();
        for(Object obj : value) {
            System.out.println(obj);
        }
    }
}
