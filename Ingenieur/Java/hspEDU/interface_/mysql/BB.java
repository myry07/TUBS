package interface_.mysql;

public class BB implements mysql {
    @Override
    public void connect() {
        System.out.println("BB 连接 mysql");
    }

    public void close() {
        System.out.println("BB 关闭 mysql");
    }
}