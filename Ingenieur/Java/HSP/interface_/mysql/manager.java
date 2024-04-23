package interface_.mysql;

public class manager {
    public void work(mysql m) {
        System.out.println(m.n1);
        m.connect();
        m.close();
    }
}
