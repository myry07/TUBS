package chapter14.Collection_.LinkedHashSet_;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

public class lhs_ {
    public static void main(String[] args) {

        HashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥拓", 1000));
        linkedHashSet.add(new Car("奥迪", 300000000));
        linkedHashSet.add(new Car("法拉利", 1000000));
        linkedHashSet.add(new Car("奥迪", 100000));
        linkedHashSet.add(new Car("保时捷", 13242000));
        linkedHashSet.add(new Car("奥迪", 300000000));

        System.out.println(linkedHashSet);
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

