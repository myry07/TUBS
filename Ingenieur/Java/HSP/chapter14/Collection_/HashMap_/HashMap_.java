package chapter14.Collection_.HashMap_;

/**
 * @author myry
 * @date 2024-26-31 21:26
 * 模仿一个简单的HashMap底层
 */

@SuppressWarnings({"all"})
public class HashMap_ {
    public static void main(String[] args) {
        Node[] table = new Node[16];
        System.out.println("table= " + table);

        //创建一个节点
        Node john = new Node("john", null);
        table[2] = john;

        Node jack = new Node("jack", null);
        john.next = jack;//形成链表

        Node rose = new Node("rose", null);
        jack.next = rose;

        Node lucy = new Node("lucy", null);
        table[3] = lucy;

        System.out.println("table= " + table);
    }
}

class Node {
    public Object item;
    public Node next;

    public Node(Object item) {
        this.item = item;
    }

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node: " + item;
    }
}