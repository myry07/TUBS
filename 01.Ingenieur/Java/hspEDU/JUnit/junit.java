import org.junit.jupiter.api.Test;

@SuppressWarnings({"all"})
public class junit {
    public static void main(String[] args) {
        new junit().m1();
        new junit().m2();
        //没有junit很麻烦
    }

    //@关键字
    @Test
    public void m1() {
        int x = 3;
        assert x == 2;
        System.out.println("m1");
    }

    @Test
    public void m2() {
        System.out.println("m2");
    }
}
