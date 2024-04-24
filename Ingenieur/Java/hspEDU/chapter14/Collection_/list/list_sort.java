package chapter14.Collection_.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author myry
 * @date 2024-52-31 10:52
 * <p>
 * List 按照价格排序
 */

@SuppressWarnings({"all"})
public class list_sort {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", 100, "曹雪芹"));
        list.add(new Book("西游记", 200, "吴承恩"));
        list.add(new Book("水浒传", 30, "施耐庵"));
        list.add(new Book("三国演绎", 400, "罗贯中"));

//        ArrayList
//        public boolean add(E e) {
//            modCount++;
//            add(e, elementData, size);
//            return true;
//        }

//        Vector
//        public synchronized boolean add(E e) {
//            modCount++;
//            add(e, elementData, elementCount);
//            return true;
//        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        sort(list);
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

    public static void sort(List list) {
        //冒泡排序
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                //list.get(i)是Object类型 需要向下转型
                Book b1 = (Book) list.get(j);
                Book b2 = (Book) list.get(j + 1);

                if (b1.getPrice() > b2.getPrice()) {
                    list.set(j, b2);
                    list.set(j + 1, b1);
                }
            }

        }
    }
}

class Book {
    private String name;
    private int price;
    private String author;

    public Book(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book: " + this.name + ", "
                + this.price + ", "
                + this.author;
    }
}
