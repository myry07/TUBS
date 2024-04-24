package exception;

public class einf {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;

        try {
            System.out.println(n1 / n2);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("666");
    }
}
