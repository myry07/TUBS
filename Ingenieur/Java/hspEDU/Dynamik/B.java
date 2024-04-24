package Dynamik;

public class B extends A{
    public int i = 20;
    public int sum() {
        return get1() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int get1() {
        return i;
    }
}
