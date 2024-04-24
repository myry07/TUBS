package extenDetail;

public class Base extends TobBase {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base(String name) {
        System.out.println(name);
        System.out.println("Base一餐被调用");
    }

    public Base(String name, int age) {
        System.out.println(name + age);
        System.out.println("Base二餐被调用");
    }
    public void test100() {
        System.out.println("test100");
    }
    protected void test200() {
        System.out.println("test200");
    }
    void test300() {
        System.out.println("test300");
    }
    private void test400() {
        System.out.println("test400");
    }

    public int getN4() {
        return n4;
    }

    public void getTest400() {
        test400();
    }
}
