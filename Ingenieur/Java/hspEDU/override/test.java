package override;

public class test {
    public static void main(String[] args) {
        Student s = new Student("小明", 29, "999", 100);
        System.out.println(s.say());

        Person p = new Person("wxl", 10);
        System.out.println(p.say());
    }
}
