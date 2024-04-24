package encap;

public class AcoountTest {
    private Account b;

    public static void main(String[] args) {
        Account a = new Account("王小龙", 30, "77777");
        System.out.println(a);

    }

    public void s() {
        b = new Account();
        b.setName("wa");
        System.out.println(b);
    }
}
