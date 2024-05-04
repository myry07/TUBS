import list.*;

public class main{
    public static void main(String[] args){
        Person p1 = new Person("Pete");
        Person p2 = new Person("Angela");
        Person p3 = new Person("Mariette");
        Person p4 = new Person("Messi");
        Person p5 = new Person("Ronaldo");
        
        ListElement head = new ListElement(p1);
        head = ListUtils.insert(head, p3);
        head = ListUtils.insert(head, p4);
        head = ListUtils.insert(head, p1);
        head = ListUtils.insert(head, p2);
        
        System.out.println(head);
        
        head = ListUtils.remove(head, p3);
        System.out.println(head);
        head = ListUtils.remove(head, p2);
        System.out.println(head);
        head = ListUtils.remove(head, p2);
        System.out.println(head);
        
        head = ListUtils.insert(head, p5);
        System.out.println(head);
        
    }
}