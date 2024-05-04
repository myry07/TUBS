package extendsExercise3;

public class test {
    public static void main(String[] args) {
        PC pc = new PC("intel", 666, 888, "Apple");
        System.out.println(pc.getDetails() + " " + pc.getBrand());

        pc.printInfo();
    }
}