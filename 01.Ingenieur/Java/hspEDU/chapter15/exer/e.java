package chapter15.exer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class e {
    public static void main(String[] args) {

        Student s1 = new Student("jack", 100);
        Student s2 = new Student("tom", 130);
        Student s3 = new Student("rose", 200);

        Set<Student> s = new HashSet<Student>();
        s.add(s1);
        s.add(s2);
        s.add(s3);

        for(Student st : s) {
            System.out.println(st);
        }

        HashMap<String, Student> m = new HashMap<String, Student>();
        m.put("no1", s1);
        m.put("no2", s2);
        m.put("no3", s3);

        Set set = m.keySet();
        for(Object st : set) {
            System.out.println(st + " - " + m.get(st));
        }



    }
}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
