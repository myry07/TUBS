package PolyArry;

public class test {
    public static void main(String[] args) {
        Person p = new Person("王小龙", 10);
        Person s1 = new Student("王小龙s1", 11, 0);
        Person s2 = new Student("王小龙s2", 12, 0);
        Person t1 = new Teacher("王小龙t1", 13, 1);
        Person t2 = new Teacher("王小龙t2", 14, 1);

        Person[] ps = new Person[5];
        ps[0] = p;
        ps[1] = s1;
        ps[2] = s2;
        ps[3] = t1;
        ps[4] = t2;

//        for(Person pss: ps) {
//            System.out.println(pss.say());
//        }

        for (int i = 0; i < ps.length; i++) {
            System.out.println(ps[i].say());

            if(ps[i] instanceof Student) {
                Student s = (Student)ps[i];
                System.out.println(s.study());
            } else if(ps[i] instanceof Teacher) {
                Teacher t = (Teacher)ps[i];
                System.out.println(t.study());
            }
        }
    }
}
