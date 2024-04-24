package chapter14.Map_.Methode_;


import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class m {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("邓超", new Book("", 100));//OK
        map.put("邓超", "孙俪");//替换
        map.put("王宝强", "马融");//OK
        map.put("宋喆", "马融");//OK
        map.put("流凌波", null);//OK
        map.put(null, "刘亦菲");//OK
        map.put("关晓彤", "鹿晗");//OK

        System.out.println(map);

        map.remove(null);
        System.out.println(map);

        Object obj = map.get("关晓彤");
        System.out.println(obj);

        System.out.println(map.containsKey("邓超"));


    }
}

class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
