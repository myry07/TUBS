package chapter14.Map_.MapExer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@SuppressWarnings({"all"})
public class exer {
    public static void main(String[] args) {

        Map map = new HashMap();
        Employee e1 = new Employee("jack", 1000000, 01);
        Employee e2 = new Employee("tom", 13400, 02);
        Employee e3 = new Employee("pony", 22000, 03);

        map.put(e1.getId(), e1);
        map.put(e2.getId(), e2);
        map.put(e3.getId(), e3);

        Set keyset = map.keySet();

        for (Object obj : keyset) {
            Employee e = (Employee) map.get(obj);
            if (e.getSal() >= 18000) {
                System.out.println(e);
            }

        }

        System.out.println();

        Collection values = map.values();
        for (Object obj : values) {
            Employee e = (Employee) obj;
            if (e.getSal() >= 18000) {
                System.out.println(e);
            }
        }

    }
}

class Employee {
    private String name;
    private int sal;
    private int id;

    public Employee(String name, int sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
