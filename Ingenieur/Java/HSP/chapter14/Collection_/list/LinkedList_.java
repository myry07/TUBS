package chapter14.Collection_.list;

/**
 * @author myry
 * @date 2024-19-31 11:19
 * <p>
 * LinkedList 双向链表
 */

@SuppressWarnings({"all"})
public class LinkedList_ {
    public static void main(String[] args) {
//        LinkedList
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("hsp");

        jack.next = tom;
        tom.prev = jack;

        tom.next = hsp;
        hsp.prev = tom;

        Node first = jack;
        Node last = hsp;

        while (true) {
            if (first == null) {
                break;
            }
            System.out.print(first + " ");
            first = first.next;
        }

        System.out.println();

        while (true) {
            if (last == null) {
                break;
            }
            System.out.print(last + " ");
            last = last.prev;

        }
    }
}

class Node {
    public Object item;
    public Node prev;
    public Node next;

    public Node(Object item) {
        this.item = item;
    }

    public String toString() {
        return item + " ->";
    }
}
