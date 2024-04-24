package interface_.mysql;

public class AA implements mysql {
    static int n2 = 5;
    @Override
    public void connect() {
        System.out.println("AA 连接 mysql");
    }

    public void close() {
        System.out.println("AA 关闭 mysql");
    }
}
