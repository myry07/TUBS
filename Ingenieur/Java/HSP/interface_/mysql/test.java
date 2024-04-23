package interface_.mysql;

public class test {
    public static void main(String[] args) {
        System.out.println(AA.n2);
        manager m = new manager();
        AA a = new AA();
        BB b = new BB();

        m.work(a);
        m.work(b);
    }
}
