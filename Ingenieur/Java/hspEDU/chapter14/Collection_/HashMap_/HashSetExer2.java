package chapter14.Collection_.HashMap_;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashSetExer2 {
    public static void main(String[] args) {
        MyDate m1 = new MyDate(1000, 10, 1);
        MyDate m2 = new MyDate(1000, 10, 1);
        MyDate m3 = new MyDate(1000, 10, 1);

        Employee2 e1 = new Employee2("milan", 18, m1);
        Employee2 e2 = new Employee2("smith", 28, m2);
        Employee2 e3 = new Employee2("milan", 18, m3);

        HashSet hashSet = new HashSet();

        hashSet.add(e1);
        hashSet.add(e2);
        hashSet.add(e3);

        System.out.println(hashSet);

    }
}
class Employee2 {
    private String name;
    private int age;
    private MyDate myDate;

    public Employee2(String name, int age, MyDate myDate) {
        this.name = name;
        this.age = age;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", myDate=" + myDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return age == employee2.age && Objects.equals(name, employee2.name) && Objects.equals(myDate, employee2.myDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, myDate);
    }
}
class MyDate {
    private int year;
    private int moth;
    private int day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && moth == myDate.moth && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, moth, day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMoth() {
        return moth;
    }

    public void setMoth(int moth) {
        this.moth = moth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int moth, int day) {
        this.year = year;
        this.moth = moth;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", moth=" + moth +
                ", day=" + day +
                '}';
    }
}
